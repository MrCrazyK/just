package com.just.entity;

import java.util.List;

public class LBT {

    private int lbtId;
    private String lbtPath;
    private String lbtUrl;
    private String lbtName;
    private int pId;

    public int getLbtId() {
        return lbtId;
    }

    public String getLbtName() {
        return lbtName;
    }

    public void setLbtName(String lbtName) {
        this.lbtName = lbtName;
    }

    public void setLbtId(int lbtId) {
        this.lbtId = lbtId;
    }

    public String getLbtPath() {
        return lbtPath;
    }

    public void setLbtPath(String lbtPath) {
        this.lbtPath = lbtPath;
    }

    public String getLbtUrl() {
        return lbtUrl;
    }

    public void setLbtUrl(String lbtUrl) {
        this.lbtUrl = lbtUrl;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
