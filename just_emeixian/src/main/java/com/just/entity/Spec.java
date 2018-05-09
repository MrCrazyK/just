package com.just.entity;

public class Spec {

    private int specId;
    private String specName;


    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Spec() {
        super();
    }

    public Spec(int specId, String specName) {
        this.specId = specId;
        this.specName = specName;
    }

    @Override
    public String toString() {
        return "Spec{" +
                "specId=" + specId +
                ", specName='" + specName + '\'' +
                '}';
    }

    public Spec(int specId) {
        this.specId = specId;
    }
}
