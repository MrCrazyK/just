package com.just.service.impl;

import com.just.service.ShoppingCarService;
import com.just.dao.ShoppingCarMapper;
import com.just.entity.Order;
import com.just.entity.Price;
import com.just.entity.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by just on 2017/12/1.
 */
@Service("ShoppingCarService")
public class ShoppingCarServiceImpl implements ShoppingCarService{

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;


    public boolean addToShoppingCar(ShoppingCar shoppingCar) {
//        4

        boolean result = shoppingCarMapper.addToShoppingCar(shoppingCar);
        System.out.println(shoppingCar);
        return result;
        //return shoppingCarMapper.addToShoppingCar(price_id,num,u_id,stock_id);
    }

    public List<ShoppingCar> selectShoppingCarsForUser(int uid) {
        return shoppingCarMapper.selectShoppingCarsForUser(uid);
    }

    public boolean deleteShoppingCarById(Integer[] shoppingCarId) {
        Integer a = shoppingCarMapper.deleteShoppingCarById(shoppingCarId);
        if (a!=0){
            return true;
        }
        return false;
    }

    public boolean updateShoppingCar(ShoppingCar shoppingCar) {
        return shoppingCarMapper.updateShoppingCar(shoppingCar);
    }

    public boolean orderShoppingCars(Order order){
        return shoppingCarMapper.orderShoppingCars(order);
    }

    public ShoppingCar findShoppingCarById(int shoppingCarId) {
        return shoppingCarMapper.selectShoppingCarById(shoppingCarId);
    }
    public boolean updateShopNum(ShoppingCar shoppingCar){
        return shoppingCarMapper.updateShopNum(shoppingCar);
    }

    public int confirmShopCar(ShoppingCar shoppingCar) {
        return shoppingCarMapper.confirmShopCar(shoppingCar);
    }

    public boolean addNumToShopping(ShoppingCar shoppingCar) {
        return shoppingCarMapper.addNumToShopping(shoppingCar);
    }

    public int countShop(int uId) {
        return shoppingCarMapper.countShop(uId);
    }


}
