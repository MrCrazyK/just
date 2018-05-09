package com.just.entity;

import java.util.Date;

/**
 * 用户浏览记录实体类，最终会汇总至User类
 */
public class UserHistory {
    private int userHistoryId;  //本类的管理id
    private int userId;     //用户id
    private Product product;     //商品id
    private int hitsFromThisUser;   //来自此用户的点击量
    private Date lastHitTime;       //此用户最后一次点击的时间

    public UserHistory() {
    }

    public int getUserHistoryId() {
        return userHistoryId;
    }

    public void setUserHistoryId(int userHistoryId) {
        this.userHistoryId = userHistoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getHitsFromThisUser() {
        return hitsFromThisUser;
    }

    public void setHitsFromThisUser(int hitsFromThisUser) {
        this.hitsFromThisUser = hitsFromThisUser;
    }

    public Date getLastHitTime() {
        return lastHitTime;
    }

    public void setLastHitTime(Date lastHitTime) {
        this.lastHitTime = lastHitTime;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "userHistoryId=" + userHistoryId +
                ", userId=" + userId +
                ", product=" + product +
                ", hitsFromThisUser=" + hitsFromThisUser +
                ", lastHitTime=" + lastHitTime +
                '}';
    }
}
