package com.just.entity;

public class Stock {
    private int stockId;

    private String stockName;

    private int stockNum;
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public Stock() {
    }

    public Stock(String stockName, int stockNum) {
        this.stockName = stockName;
        this.stockNum = stockNum;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", stockNum=" + stockNum +
                '}';
    }
}
