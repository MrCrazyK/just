package com.just.entity;

public class Address {


    private int addressId;  //本表管理id
    private int userId;         //所属用户id
    private String detailedAddress;     //地址详情
    private String recUser;     //收货人地址
    private String phone;       //收货人联系方式
    private City city;          //收货地址对应city
    private boolean isDefault;  //表示该地址是否为默认地址
//    private String province;//省份
//    private String city;    //市
//    private String area;    //区



    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getArea() {
//        return area;
//    }
//
//    public void setArea(String area) {
//        this.area = area;
//    }


    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public int getuId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRecUser() {
        return recUser;
    }

    public void setRecUser(String recUser) {
        this.recUser = recUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Address(int userId, String detailedAddress, String recUser, String phone, City city) {
        this.userId = userId;
        this.detailedAddress = detailedAddress;
        this.recUser = recUser;
        this.phone = phone;
        this.city = city;
    }
}
