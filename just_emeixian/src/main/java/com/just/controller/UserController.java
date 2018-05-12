package com.just.controller;

import com.just.Util.FastJson_All;
import com.just.Util.StringUtil;
import com.just.entity.Product;
import com.just.entity.User;
import com.just.entity.UserFavorite;
import com.just.entity.UserHistory;
import com.just.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.just.Util.VerifyCodeUtil;

/**
 * Created by 11253 on 2018/3/27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册验证
//    @RequestMapping(value = "/reg.do",method = RequestMethod.GET)
//    public  void reg(User user,HttpServletResponse response) throws IOException {
//        System.out.println("registering:"+ user);
//        User regUser = userService.confirmUser(user.getUserName());
//        String result;
//        if(regUser == null){
//            userService.addUser(user);
//            result = "注册成功";
//        }else{
//            result = "用户已存在,注册失败!";
//        }
//        FastJson_All.toJson(result,response);
//    }


    @RequestMapping(value = "/reg",produces = "text/json;charset=UTF-8")
    public void reg(String userPhone,String vcode,String userPwd,String userPwdT,HttpServletResponse response) {
        String msg;
        //生成用来处理手机号的正则Matcher，保证传递到后方的手机号是正确的
        String regex = "^[1][3,4,5,7,8][0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userPhone);
        //安全处理
        if (vcode == null) {
            msg = "验证码不能为空";
        } else if (userPwd == null || "".equals(userPwd)) {
            msg = "密码不能为空";
        } else if (userPwdT == null || "".equals(userPwdT)) {
            msg = "确认密码不能为空";
        } else if (!userPwdT.equals(userPwd)) {
            msg = "两次密码输入不一致";
        } else if (!matcher.matches()) {
            msg = "请输入正确的手机号";
        } else if ( userService.confirmUser(userPhone) != null){
            msg = "用户名已存在,请重新输入";
        }else {

            //String realVcode = verifyCodeUtil.getText().toLowerCase();  //获得后台生成的验证码内容并转小写
            //vcode = vcode.toLowerCase();    //将前端传过来的vcode转小写，方便验证
            //if (!realVcode.equals(vcode)){
            //msg = "验证码输入不正确";
            try {
                User user = new User();
                user.setPassword(userPwd);
                user.setPhoneNum(userPhone);
                userService.addUser(user);
                // userService.userPhone(userPhone);   //更新用户信息表中的手机号
                msg = "注册成功";
            } catch (Exception e) {
                msg = "该手机号已注册";
                System.out.println(msg);
            }
        }
        FastJson_All.toJson(msg, response);
    }

    //登录验证用的
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void confirmUser(User user, HttpServletResponse response, HttpServletRequest request){
        System.out.println("logging:"+user);
        user.setPassword(StringUtil.getMdf(user.getPassword()));
        String result;
        User loginUser = userService.confirmUser(user.getUserName());
        Map<String,Object> results = new HashMap<String, Object>();
        if (user.getUserName() == null || "".equals(user.getUserName().trim())){
            result = "用户名或密码错误";
        }else if (user.getPassword() == null || "".equals(user.getPassword().trim())){
            result = "用户名或密码错误";
        }else if(loginUser != null && user.getPassword().equals(loginUser.getPassword())){
            if (user.getUserType() == 1){
                result = "admin";
            }else{
                result = "loginSuccess";
                results.put("user",loginUser);
            }
            request.getSession().setAttribute("currentUser",loginUser);
            Cookie cookieName = new Cookie("name",user.getName()
            );
            Cookie cookiePwd = new Cookie("pwd",user.getName());
            cookieName.setMaxAge(60*60*24);
            cookiePwd.setMaxAge(60*60*24);
            response.addCookie(cookieName);
            response.addCookie(cookiePwd);
            cookieName.setPath("/");
            cookieName.setMaxAge(2100000000);
            cookiePwd.setPath("/");
            cookiePwd.setMaxAge(2100000000);
            response.addCookie(cookieName);
            response.addCookie(cookiePwd);
            //添加cookie
        }else {
            result = "error";
        }
        results.put("msg",result);
        FastJson_All.toJson(results,response);
    }

    //注册用户名失焦
    @RequestMapping(value = "/confirm",method = RequestMethod.GET)
    public void focus(User user,HttpServletResponse response) {
        boolean result ;
        User regUser = userService.confirmUser(user.getUserName());
        if (regUser == null) {
            result = true;
        } else {
            result = false;
        }
        FastJson_All.toJson(result,response);
    }

    @InitBinder("user")
    public void initUser(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("user.");
    }

    //用户信息的修改
    @RequestMapping(value = "/updateInfo")
    public void updateUser(HttpServletResponse response,Integer gener, String email, String name, String detailed, Integer road, String userName, @DateTimeFormat(pattern="yyyy/MM/dd") Date birth) throws IOException {
        System.out.println("aa" + gener);
        User user = new User();
        user.setGener(gener);
        user.setUserName(userName);
        user.setBirth(birth);
        user.setDetailed(detailed);
        user.setRoad(road);
        user.setEmail(email);
        user.setName(name);
        userService.updateUser(user);
        FastJson_All.toJson("success",response);
    }

    // 密码的修改
    //用户信息的修改
    @RequestMapping(value = "/updatePassword")
    public void updatePassword(String password,String userName,String newPass,HttpServletResponse response) throws IOException {
        User user = new User();
        user.setPassword(newPass);
        user.setUserName(userName);
        if (password.equals(userService.confirmUser(userName).getPassword())){
            userService.updatePassword(user);
            FastJson_All.toJson("success", response);
        }else {
            FastJson_All.toJson("密码错误", response);
        }
    }

    //上传头像
    @RequestMapping("/upload")
    public void updateHeadImg(@RequestParam("myFile") MultipartFile files, HttpServletRequest request, HttpServletResponse response){
        System.out.println("图片："+files);
        User user = (User) request.getSession().getAttribute("user1");
        System.out.println("用户"+user);
        boolean results = false;
//        String headImg = "/Users/just/Desktop/mvcImg/Lbt/"+user.getuId()+".jpg";
        String headImg = "/Users/just/Desktop/mvcImg/Lbt/wym.jpg";
        File file = new File(headImg);
        try {
            FileUtils.copyInputStreamToFile(files.getInputStream(),file);
            String headImgUrl = "http://10.80.13.111:8080/resource/views/headImg/"+user.getuId()+".jpg";
            user.setHeadImgUrl(headImgUrl);
            boolean result = userService.updateHeadImgUrl(user);
            if (result){
                results = true;
                User user1 = userService.findUserByuId(user.getuId());
                request.getSession().setAttribute("user1",user1);
            }
            FastJson_All.toJson(results,response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();  //验证码工具类实例，在调用的时候进行初始化
//    /**
//     * 登录用的方法，其间会处理session和cookie
//     * @param userName
//     * @param userPwd
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/login",produces = "text/json;charset=UTF-8")
//    public void login(String userName, String userPwd, HttpServletRequest request, HttpServletResponse response){
//        //JSONObject bigOne = JSONObject.parseObject("{}");
//        Map<String,Object> bigOne = new HashMap();
//        String msg;
//        User user = null;
//        //安全处理
//        if (userName == null || "".equals(userName.trim())){
//            msg = "用户名或密码错误";
//        }else if (userPwd == null || "".equals(userPwd.trim())){
//            msg = "用户名或密码错误";
//        }else{
//            //通过service获取登录结果
//            user = userService.allForOne(userName,userPwd);
//            System.out.println(user);
//            //对session 和cookie 做处理
//            if (user != null){
//                msg = "登录成功";
//                request.getSession().setAttribute("currentUser",user);
//                Cookie cookie = new Cookie("userToken",user.getUserToken());
//                cookie.setPath("/");
//                cookie.setMaxAge(2100000000);
//                response.addCookie(cookie);
//            }else{
//                msg = "用户名或密码错误";
//            }
//        }
//        bigOne.put("user",user);
//        bigOne.put("msg",msg);
//        FastJson_All.toJson(bigOne,response);
//    }

//    /**
//     * 登出用的方法，其间会处理session和cookie
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/logout",produces = "text/json;charset=UTF-8")
//    public void logout(HttpServletRequest request, HttpServletResponse response){
//        //JSONObject bigOne = JSONObject.parseObject("{}");
//        Map<String,Object> bigOne = new HashMap();
//        String msg = "";
//        try {
//            //清除session中的currentUser
//            request.getSession().removeAttribute("currentUser");
//            //清除cookie中的userToken
//            Cookie cookie = new Cookie("userToken",null);
//            cookie.setPath("/");
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//            msg = "退出成功";
//        } catch (Exception e) {
//            msg = "未知错误";
//        }
//        //返回退出结果
//        bigOne.put("msg",msg);
//
//        FastJson_All.toJson(bigOne,response);
//    }





    //浏览时添加历史记录
    //参数:商品id,用户id(session)
    @RequestMapping("/addHistory")
    public void addHistory(HttpServletRequest request, HttpServletResponse response,int goodId){
        User user = (User) request.getSession().getAttribute("currentUser");
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getuId());
        userHistory.setProduct(new Product(goodId));
        userHistory.setLastHitTime(new Date());
        userService.addToHistory(userHistory);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/delHistory")
    public void delHistory(HttpServletResponse response,int userHistoryId){
        userService.deleteHistory(userHistoryId);
        FastJson_All.toJson("success",response);
    }
    //查看历史
    //参数:用户id(session)
    @RequestMapping("/showHistory")
    public void showHistory(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("currentUser");
        List<UserHistory> userHistories = userService.findHistoryList(user.getuId());
        System.out.println(userHistories);
        FastJson_All.toJson(userHistories,response);
    }
    //收藏
    //参数:商品id,用户id(session)
    @RequestMapping("/addFavor")
    public void addFavor(HttpServletRequest request, HttpServletResponse response,int goodId){
        User user = (User) request.getSession().getAttribute("currentUser");
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(user.getuId());
        userFavorite.setProduct(new Product(goodId));
        userFavorite.setAddTime(new Date());
        userService.addToFocus(userFavorite);
        FastJson_All.toJson("success",response);
    }
    //取消收藏
    //参数:商品id,用户id(session)
    @RequestMapping("/delFavor")
    public void delFavor(HttpServletRequest request, HttpServletResponse response,int goodId){
        User user = (User) request.getSession().getAttribute("currentUser");
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(user.getuId());
        userFavorite.setProduct(new Product(goodId));
        userService.disFocus(userFavorite);
        FastJson_All.toJson("SUCCESS",response);
    }
    //查看收藏列表
    //参数:用户id(session)
    @RequestMapping("/showFavor")
    public void showFavor(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("currentUser");
        FastJson_All.toJson(userService.findFocusList(user.getuId()),response);
    }

    /**
     * 生成验证码并返回给前端的方法
     * @param response
     */
    @RequestMapping("/getv")
    public void getv(HttpServletResponse response){
        verifyCodeUtil = new VerifyCodeUtil();  //实例化验证码工具类
        BufferedImage bi = verifyCodeUtil.createImage();    //生成验证码
        try {
            OutputStream os = response.getOutputStream();   //获取返回流
            VerifyCodeUtil.output(bi,os);   //将图片返回
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value="/showHeadImg.do")
    public void addHeadImg(HttpServletRequest request,HttpServletResponse response) throws Exception{
        User user = (User) request.getSession().getAttribute("currentUser");
        String headPath = userService.showHeadImg(user.getuId());
        Map<String,String> success = new HashMap();
        success.put("path",headPath);
        FastJson_All.toJson(success,response);
    }




    @RequestMapping(value="/addHeadImg.do",params="upLoadPicture")
    public void addHeadImg(MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
        String path="../headImgs";
        //创建文件
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        User user = (User) request.getSession().getAttribute("currentUser");

        //返回原来在客户端的文件系统的文件名
        String fileName = file.getOriginalFilename();
        //username+后缀名
        String img = user.getUserName() + fileName.substring(fileName.lastIndexOf("."));//zhao.jpg
        FileOutputStream imgOut=new FileOutputStream(new File(dir,img));//根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
        imgOut.write(file.getBytes());//返回一个字节数组文件的内容
        imgOut.close();
        Map<String, String> map=new HashMap();
        String rpath = path+"/"+img;
        map.put("rPath",rpath);
        User userInfo = new User();
        userInfo.setuId(user.getuId());
        userInfo.setHeadImgUrl(rpath);
        userService.setHeadImg(userInfo);
        FastJson_All.toJson(map,response);
    }
    @RequestMapping(value="/changeHeadImg.do",params="upLoadPicture")
    public void changeHeadImg(MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
        String path="../headImgs";
        //创建文件
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        User user = (User) request.getSession().getAttribute("currentUser");

        //返回原来在客户端的文件系统的文件名
        String fileName = file.getOriginalFilename();
        //username+后缀名
        String img = user.getUserName() + fileName.substring(fileName.lastIndexOf("."));//zhao.jpg
        FileOutputStream imgOut=new FileOutputStream(new File(dir,img));//根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
        imgOut.write(file.getBytes());//返回一个字节数组文件的内容
        imgOut.close();
        Map<String, String> map=new HashMap();
        String rpath = path+"/"+img;
        map.put("rPath",rpath);
        User userInfo = new User();
        userInfo.setuId(user.getuId());
        userInfo.setHeadImgUrl(rpath);
        userService.changeHeadImg(userInfo);
        FastJson_All.toJson(map,response);
    }
//    @RequestMapping("/showEdu")
//    public void selectAllEdu(HttpServletResponse response){
//        FastJson_All.toJson(userService.selectAllEdu(),response);
//    }
//    @RequestMapping("/showSalary")
//    public void selectAllSalary(HttpServletResponse response){
//        FastJson_All.toJson(userService.selectAllSalary(),response);
//    }
//    @RequestMapping("/showIndustry")
//    public void selectAllIndustry(HttpServletResponse response){
//        FastJson_All.toJson(userService.selectAllIndustry(),response);
//    }
//    @RequestMapping(value = "/updateInfo",produces = "text/json;charset=UTF-8",method = RequestMethod.POST)
//    public void updateUserInfo(String userPhone,String userGender,String userIsMarry,int userEdu,int userSalary,int userIndustry,String userLikes,Date birthday,String likeName,HttpServletResponse response,HttpServletRequest request){
//        User user = (User) request.getSession().getAttribute("currentUser");
//        int uId = user.getUserId();
//        UserInfo userInfo = new UserInfo(userPhone,userLikes,userGender,new UserEdu(userEdu),new UserIndustry(userIndustry),new UserSalary(userSalary),userIsMarry,birthday,likeName,uId);
//        userService.updateUserInfo(userInfo);
//        FastJson_All.toJson("success",response);
//    }
//    //上传用户资料
//    @RequestMapping(value = "/addInfo",produces = "text/json;charset=UTF-8",method = RequestMethod.POST)
//    public void addUserInfo(String userPhone,String userGender,String userIsMarry,int userEdu,int userSalary,int userIndustry,String userLikes,Date birthday,String likeName,HttpServletResponse response,HttpServletRequest request){
//        User user = (User) request.getSession().getAttribute("currentUser");
//        int uId = user.getUserId();
//        UserInfo userInfo = new UserInfo(userPhone,userLikes,userGender,new UserEdu(userEdu),new UserIndustry(userIndustry),new UserSalary(userSalary),userIsMarry,birthday,likeName,uId);
//        userService.addUserInfo(userInfo);
//        FastJson_All.toJson("success",response);
//    }
//
//    @RequestMapping("/showUserInfo")
//    public void showUserInfo(HttpServletResponse response,HttpServletRequest request){
//        System.out.println("show");
//        User user = (User) request.getSession().getAttribute("currentUser");
//        int uId = user.getUserId();
//        UserInfo userInfo = userService.showUserInfo(uId);
//
//        System.out.println(userInfo);
//        FastJson_All.toJson(userInfo,response);
//    }

//    //加入购物车
//    //参数:最小货格,用户id(session)
//    @RequestMapping("/addShopCar")
//    public void addShopCar(HttpServletRequest request, HttpServletResponse response,int goodId){
//        User user = (User) request.getSession().getAttribute("currentUser");
//        FastJson_All.toJson("success",response);
//    }
//    //删除购物车
//    //参数:要删除的商品id数组,用户id(session)
//    @RequestMapping("/delShopCar")
//    public void delShopCar(HttpServletRequest request, HttpServletResponse response,int goodId){
//        User user = (User) request.getSession().getAttribute("currentUser");
//        FastJson_All.toJson("success",response);
//    }
//    //查看购物车
//    //参数:用户id(session)
//    @RequestMapping("/showShopCar")
//    public void showShopCar(HttpServletRequest request, HttpServletResponse response){
//        User user = (User) request.getSession().getAttribute("currentUser");
//        FastJson_All.toJson(userService.findFocusList(user.getUserId()),response);
//    }
}
