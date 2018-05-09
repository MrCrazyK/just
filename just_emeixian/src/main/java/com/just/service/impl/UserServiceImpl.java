package com.just.service.impl;

import com.just.dao.UserMapper;
import com.just.entity.User;
import com.just.entity.UserFavorite;
import com.just.entity.UserHistory;
import com.just.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.just.Util.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by 11253 on 2018/3/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User confirmUser(String userName) {
        return userMapper.confirmUser(userName);
    }

    //@Transactional
    public void addUser(User user) {
        user.setPassword(StringUtil.getMdf(user.getPassword()));   //对用户的密码进行md5加密
        userMapper.addUser(user);

    }
    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
    @Transactional

    public void updatePassword(User user) {
        user.setPassword(StringUtil.getMdf(user.getPassword()));   //对用户的密码进行md5加密
        userMapper.updatePassword(user);
    }

    public int confirmUserType(User user) {
        return userMapper.confirmUserType(user);
    }

    public boolean updateHeadImgUrl(User user) {
        return userMapper.updateHeadImgUrl(user);
    }

    public User findUserByuId(Integer uId) {
        return userMapper.findUserByuId(uId);
    }






    /**
     * 用户登录用的方法,会和数据库中存储的用户名、md5加密密码进行验证。
     * @param userName,userPwd
     * @return
     */
    public User allForOne(String userName,String userPwd){
        User user = new User();     //创建一个User实例，与Dao层配合使用
        user.setUserName(userName);     //为该实例的userName进行赋值
        userPwd = StringUtil.getMdf(userPwd);   //对用户的密码进行md5加密
        user.setPassword(userPwd);   //为该实例的userPwd进行赋值
        User tempU = userMapper.userLogin(user);   //将组合好的实例传递给dao层进行查询
        return tempU;   //通过是否有符合条件的结果返回来确定是否登录成功
    }

    /**
     * 基础注册方法
     * @param userPhone
     * @param userPwd
     * @return
     */
    public int userReg(String userPhone,String userPwd){
        User user = new User();     //新建一个提供给dao层的user容器
        user.setUserName(userPhone);    //设置默认的用户名，与该用户手机号一致
        userPwd = StringUtil.getMdf(userPwd);   //将密码进行md5加密
        String userToken = StringUtil.getMdf(userPhone);    //生成用户token，即对用户手机号进行md5加密后得到的字符串
        user.setPassword(userPwd);   //设置用户密码
        user.setUserToken(userToken);   //设置用户token
        return userMapper.userReg(user);   //进行插入，并返回受影响的条数作为插入成功与否的判断
    }

    /**
     * 注册时用来同时更新用户信息表中手机号的方法，此方法会先进行一次查询，获取当前用户id和匹配的手机号
     * (仅限注册时使用，此时userName=userPhone)
     * @param userName
     * @return
     */
    public int userPhone(String userName){
        User user = userMapper.getUserPhone(userName);
        return userMapper.userPhone(user);
    }
    //根据用户id查找所有收藏商品信息
    public List<UserFavorite> findFocusList(int uId) {
        return userMapper.findFocusList(uId);
    }
    //为用户将某一商品添加到收藏夹
    public boolean addToFocus(UserFavorite userFavorite) {
        return userMapper.addToFocus(userFavorite);
    }
    //为用户删除某一条收藏夹内容
    public boolean deleteFocus(int favoriteId) {
        return userMapper.deleteFocus(favoriteId);
    }
    //为用户取消对某一商品的关注
    public boolean disFocus(UserFavorite userFavorite) {
        return userMapper.disFocus(userFavorite);
    }
    //显示某一用户的所有历史访问
    public List<UserHistory> findHistoryList(int uId) {
        return userMapper.findHistoryList(uId);
    }
    //将某一商品添加进历史访问中
    public boolean addToHistory(UserHistory userHistory) {

        userHistory.setLastHitTime(new Date());
        if (userMapper.countHistory(userHistory) > 0){
            return userMapper.updateHistory(userHistory);
        }
        return userMapper.addToHistory(userHistory);
    }
    //将某一商品从历史中删除
    public boolean deleteHistory(int historyId) {
        return userMapper.deleteHistory(historyId);
    }




    public void updateUserInfo(User userInfo){
        userMapper.updateUserInfo(userInfo);
    }

    public void addUserInfo(User userInfo){
        userMapper.addUserInfo(userInfo);
    }

    public User showUserInfo(int uId) {
        System.out.println("灌灌灌灌灌过");
        return userMapper.showUserInfo(uId);
    }

    public boolean setHeadImg(User userInfo) {
        return userMapper.setHeadImg(userInfo);
    }

    public boolean changeHeadImg(User userInfo) {
        return userMapper.changeHeadImg(userInfo);
    }

    public String showHeadImg(int userId){
        return userMapper.showHeadImg(userId);
    }
}
