package com.just.entity;

import java.util.Date;
import java.util.List;

public class Product {
    private int productId;
    //    规格

    private String pSpec;
    //    标签
    private int categoryId;
    //    最低价格
    private int pMoney;
    //    图片(主图片 用于显示）
    private String pImg;
    //    商品编号
    private int pNumber;
    //  商品名称
    private String pName;
    //  商品后买返还积分
    private int pPoint;
    //  商品信息
    private String pInfo;
    //  商品上架时间
    private Date pTime;
    //  商品会员折扣
    private double pDiscount;
    //  商品规格集合
    private List<Spec> specs;
    //  商品容量集合
    private List<Unit> units;

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public int getpId() {
        return productId;
    }

    public void setpId(int pId) {
        this.productId = pId;
    }

    public String getpSpec() {
        return pSpec;
    }

    public void setpSpec(String pSpec) {
        this.pSpec = pSpec;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int category_id) {
        this.categoryId = categoryId;
    }

    public int getpMoney() {
        return pMoney;
    }

    public void setpMoney(int pMoney) {
        this.pMoney = pMoney;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pId=" + productId +
                ", pSpec='" + pSpec + '\'' +
                ", category_id=" + categoryId +
                ", pMoney=" + pMoney +
                ", pImg='" + pImg + '\'' +
                ", pNumber=" + pNumber +
                ", pName='" + pName + '\'' +
                ", pPoint=" + pPoint +
                ", pInfo=" + pInfo +
                ", pTime=" + pTime +
                ", pDiscount=" + pDiscount +
                '}';
    }


    public int getpNumber() {
        return pNumber;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPoint() {
        return pPoint;
    }

    public void setpPoint(int pPoint) {
        this.pPoint = pPoint;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public double getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(double pDiscount) {
        this.pDiscount = pDiscount;
    }

    public Product(int pId, String pSpec, int category_id, int pMoney, String pImg) {
        this.productId = pId;
        this.pSpec = pSpec;
        this.categoryId = category_id;
        this.pMoney = pMoney;
        this.pImg = pImg;
    }

    public Product(int pId) {
        this.productId = pId;
    }

    public Product() {
        super();
    }
}
