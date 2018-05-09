package com.just.service;


import com.just.entity.Order;
import com.just.entity.ShoppingCar;

import java.util.List;

/**
 * Created by just on 2017/12/2.
 */
public interface ShoppingCarService {

    //public int addToShoppingCar(int price_id,int num,int u_id,int stock_id);
    public boolean addToShoppingCar(ShoppingCar shoppingCar);
    public List<ShoppingCar> selectShoppingCarsForUser(int uid);
    public boolean deleteShoppingCarById(Integer[] shoppingCarId);
    public boolean updateShoppingCar(ShoppingCar shoppingCar);
    public boolean orderShoppingCars(Order order);
    public ShoppingCar findShoppingCarById(int shoppingCarId);
    public boolean updateShopNum(ShoppingCar shoppingCar);

    public int confirmShopCar(ShoppingCar shoppingCar);
    public boolean addNumToShopping(ShoppingCar shoppingCar);
    public int countShop(int uId);

}
