package com.just.service;

import com.just.entity.User;
import com.just.entity.UserFavorite;
import com.just.entity.UserHistory;

import java.util.List;

/**
 * Created by 11253 on 2018/3/27.
 */
public interface UserService {
    public User confirmUser(String userName);
    public void addUser(User user);
    public void updateUser(User user);
    public void updatePassword(User user);
    public int  confirmUserType(User user);
    public boolean updateHeadImgUrl(User user);
    public User findUserByuId(Integer uId);
    public User allForOne(String userName,String userPwd);   //用户登录用的方法
    public int userReg(String userPhone,String userPwd);  //基础注册方法
    public int userPhone(String userName);    //注册时新增用户手机号信息的方法


    //收藏部分
    public List<UserFavorite> findFocusList(int uId);
    public boolean addToFocus(UserFavorite userFavorite);
    public boolean deleteFocus(int favoriteId);
    public boolean disFocus (UserFavorite userFavorite);

    //历史记录部分
    public List<UserHistory> findHistoryList(int uId);
    public boolean addToHistory(UserHistory userHistory);
    public boolean deleteHistory(int historyId);


    public String showHeadImg(int uId);
    public boolean setHeadImg(User userInfo);
    public boolean changeHeadImg(User userInfo);
}
