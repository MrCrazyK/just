package com.just.dao;

import com.just.entity.Order;
import com.just.entity.ShoppingCar;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface ShoppingCarMapper {
    //public int addToShoppingCar(int price_id,int num,int u_id,int stock_id);
    public boolean addToShoppingCar(ShoppingCar shoppingCar);
    public List<ShoppingCar> selectShoppingCarsForUser(int uid);
    public List<ShoppingCar> selectShoppingCarsForOrder(int orderId);
    public Integer deleteShoppingCarById(@Param("shoppingCarId") Integer[] shoppingCarId);
    public boolean updateShoppingCar(ShoppingCar shoppingCar);
    public ShoppingCar selectShoppingCarById(int shoppingCarId);


    public boolean orderShoppingCars(Order order);
    public boolean updateShopNum(ShoppingCar shoppingCar);
    public int confirmShopCar(ShoppingCar shoppingCar);
    public boolean addNumToShopping(ShoppingCar shoppingCar);

    public int countShop(int uId);

}
