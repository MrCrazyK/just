package com.just.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 11253 on 2018/3/19.
 用户类
 * */
public class User {

//主键
    private Integer uId;
//    用户名
    private String userName;
//    密码
    private String password;
//    登录/注册使用的电话号码
    private String phoneNum;
//    头像路径
    private String headImgUrl;
//     用户生日
    @DateTimeFormat(pattern="yyyy/MM/dd HH")
    private Date birth;
//    性别
    private  int gener;
//    邮箱地址
    private  String email;
//    用户昵称
    private  String name;
//    用户类型
    private int userType;

    private  String detailed;
    private  int road;
    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getRoad() {
        return road;
    }

    public void setRoad(int road) {
        this.road = road;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getGener() {
        return gener;
    }

    public void setGener(int gener) {
        this.gener = gener;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", poneNum='" + phoneNum + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", birth=" + birth +
                ", gener=" + gener +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", detailed='" + detailed + '\'' +
                ", road=" + road +
                ", userType=" + userType +
                '}';
    }

    public User(Integer uId) {
        this.uId = uId;
    }
}
