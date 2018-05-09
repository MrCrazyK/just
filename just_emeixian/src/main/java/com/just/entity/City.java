package com.just.entity;

public class City {

    private int cityId;
    private String cityName;
    private int parentId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public City(int cityId) {
        this.cityId = cityId;
    }

    public City() {
    }
}
