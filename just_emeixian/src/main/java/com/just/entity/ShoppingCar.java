package com.just.entity;

/**
 * Created by just on 2017/12/4.
 */
public class ShoppingCar {

    private int shoppingCarId;
    private Price price;
    private int num;
    private Stock stock;
    private User user;
    private int uId;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getShoppingCarId() {
        return shoppingCarId;
    }

    public void setShoppingCarId(int shoppingCarId) {
        this.shoppingCarId = shoppingCarId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



    public ShoppingCar() {
    }


    public ShoppingCar(Price price, int num,  Stock stock) {
        this.price = price;
        this.num = num;

        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ShoppingCarController{" +
                "shoppingCarId=" + shoppingCarId +
                ", price=" + price +
                ", num=" + num +
                ", stock=" + stock +
                ", uId=" + uId +
                '}';
    }
}
