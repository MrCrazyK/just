package com.just.dao;

import com.just.entity.User;
import com.just.entity.UserFavorite;
import com.just.entity.UserHistory;

import java.util.List;

/**
 * Created by 11253 on 2018/3/27.
 */

public interface UserMapper {
    public User confirmUser(String userName);   //确认用户民
    public void addUser(User user);             //注册时,插入用户
    public void updateUser(User user);          //更新用户
    public void updatePassword(User user);      //更新密码
    public int confirmUserType(User user);      //查找用户类型
    public User findUserByuId(Integer uId);     //根据id查找用户
    public void updateUserInfo(User userInfo);  //更新用户信息
    public void addUserInfo(User userInfo);     //新增(插入)用户信息
    public User showUserInfo(int uId) ;         //根据用户id显示用户信息


    public boolean updateHeadImgUrl(User user); //修改用户头像
    public String showHeadImg(int userId);      //根据id查找头像路径
    public boolean setHeadImg(User userInfo) ;  //设置用户头像
    public boolean changeHeadImg(User userInfo) ;//修改用户头像


    //收藏部分
    public List<UserFavorite> findFocusList(int uId);           //根据id查找当前用户的收藏列表
    public boolean addToFocus(UserFavorite userFavorite);       //将某个商品新增到用户的收藏列表
    public boolean deleteFocus(int favoriteId);                 //将某个商品从收藏列表删除
    public boolean disFocus(UserFavorite userFavorite);         //取消对某个商品的关注

    //历史记录部分
    public List<UserHistory> findHistoryList(int uId);          //根据id查找当前用户浏览历史
    public int countHistory(UserHistory userHistory);           //显示历史浏览数量
    public boolean updateHistory(UserHistory userHistory);      //更新浏览历史
    public boolean addToHistory(UserHistory userHistory);       //新增浏览历史
    public boolean deleteHistory(int historyId);                //将某个商品从浏览历史中删除

    public User userLogin(User user);
    public int userReg(User user);
    public int userPhone(User user);
    public User getUserPhone(String userName);

}
