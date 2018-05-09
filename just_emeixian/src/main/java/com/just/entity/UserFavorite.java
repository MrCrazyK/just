package com.just.entity;

import java.util.Date;

public class UserFavorite {
    private int userFavoriteId;    //本类的管理id
    private Product product;     //商品
    private int userId;     //所属的用户id
    private Date addTime;   //添加的时间

    public UserFavorite() {
    }

    public int getUserFavoriteId() {
        return userFavoriteId;
    }

    public void setUserFavoriteId(int userFavoriteId) {
        this.userFavoriteId = userFavoriteId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "UserFavorite{" +
                "userFavoriteId=" + userFavoriteId +
                ", product=" + product +
                ", userId=" + userId +
                ", addTime=" + addTime +
                '}';
    }
}
