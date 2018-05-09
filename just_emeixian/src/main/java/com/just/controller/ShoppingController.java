package com.just.controller;

import com.just.Util.FastJson_All;
import com.just.entity.*;
import com.just.service.OrderService;
import com.just.service.ShoppingCarService;
import com.just.service.StockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingCarService shoppingCarService;
    @Autowired
    private StockService stockService;



    @RequestMapping(value = "/findOrderById",method = RequestMethod.GET)
    public void findOrder(int oId, HttpServletResponse response){
        FastJson_All.toJson(orderService.selectOrderById(oId),response);
    }
    //    查找当前用户的所有订单
    @RequestMapping(value = "/usersOrders",method = RequestMethod.GET)
    public void findOrdersForUser(int uId, HttpServletResponse response){
        FastJson_All.toJson(orderService.findOrdersForUser(uId),response);
    }
    //      将购物车对象添加到订单
    @RequestMapping(value = "/addNewOrder",method = RequestMethod.GET)
    public void findOrdersForUser(IDS shoppingCarIds, int addressId, int uId, HttpServletResponse response){

        Order order = new Order();
        Address address = new Address();
        User user = new User();
        Date date = new Date();

        user.setuId(uId);
        address.setAddressId(addressId);
        order.setAddress(address);
        order.setUser(user);
        order.setOrderTime(date);
        System.out.println(shoppingCarIds);
        List<ShoppingCar> shoppingCars = new ArrayList<ShoppingCar>();
        for (int id:shoppingCarIds.getIds()) {
            ShoppingCar shoppingCar = new ShoppingCar();
            shoppingCar.setShoppingCarId(id);
            shoppingCars.add(shoppingCar);
        }
        order.setShoppingCars(shoppingCars);
        orderService.addNewOrder(order);
        System.out.println(order.getOrderId());
        shoppingCarService.orderShoppingCars(order);
        FastJson_All.toJson(orderService.selectOrderById(order.getOrderId()),response);
    }
    //    付款时将订单状态改为已支付并更改库存
    @Transactional
    @RequestMapping("/payOrder")
    public void payOrder(int orderId,HttpServletResponse response){
        Order order = orderService.selectOrderById(orderId);
        if (orderService.payOrder(orderId)){
            for (ShoppingCar shoppingCar:order.getShoppingCars()) {
                Stock stock = shoppingCar.getStock();
                stock.setStockNum(shoppingCar.getNum());
                stockService.updateByOrder(stock);
            }
        }
        FastJson_All.toJson("订单完成",response);

    }

    @RequestMapping(value = "/findShoppingById",method = RequestMethod.GET)
    public void findShoppingCar(int shoppingCarId, HttpServletResponse response){
        FastJson_All.toJson(shoppingCarService.findShoppingCarById(shoppingCarId),response);
    }

    //    添加到购物车 传入购物车对象
    @RequestMapping("/addShopping")
    public void addToShoppingCar(@Param("priceId") Integer priceId, @Param("num")Integer num, @Param("uId")Integer uId, @Param("stockId")Integer stockId, HttpServletResponse response){
        if (priceId == null || num == null || uId == null || stockId == null){
            FastJson_All.toJson("空指针",response);
        }else {
            ShoppingCar shoppingCar = new ShoppingCar();
            Price price = new Price();
            price.setPriceId(priceId);
            User user = new User();
            user.setuId(uId);
            Stock stock = new Stock();
            stock.setStockId(stockId);
            shoppingCar.setPrice(price);
            shoppingCar.setNum(num);
            shoppingCar.setUser(user);
            shoppingCar.setStock(stock);
            int id = shoppingCarService.confirmShopCar(shoppingCar);
            if (id != 0){
                shoppingCar.setShoppingCarId(id);
                shoppingCarService.addNumToShopping(shoppingCar);
                FastJson_All.toJson("已添加至已有购物车",response);
            }else{
                shoppingCarService.addToShoppingCar(shoppingCar);
                FastJson_All.toJson("已添加到新的购物车",response);
            }

        }

    }
    //    根据用户id查找购物车
    @RequestMapping("/usersShoppings")
    public void findShoppingCars(int uId,HttpServletResponse response){
        FastJson_All.toJson(shoppingCarService.selectShoppingCarsForUser(uId),response);

    }


    //    根据购物车id更新购物车
    @RequestMapping(value="/updateShopping",method = RequestMethod.GET)
    public void updateShoppingCar(@Param("priceId") Integer priceId, @Param("num")Integer num, @Param("uId")Integer uId, @Param("stockId")Integer stockId, HttpServletResponse response){
        ShoppingCar shoppingCar = new ShoppingCar();
        Price price = new Price();
        price.setPriceId(priceId);
        User user = new User();
        user.setuId(uId);
        Stock stock = new Stock();
        stock.setStockId(stockId);
        shoppingCar.setPrice(price);
        shoppingCar.setNum(num);
        shoppingCar.setUser(user);
        shoppingCar.setStock(stock);
        FastJson_All.toJson(shoppingCarService.updateShoppingCar(shoppingCar),response);

    }

    //更改购物车商品的数量
    @RequestMapping("/changeShoppingNum")
    public void changeNum(int num,int shoppingCarId,HttpServletResponse response){
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setNum(num);
        shoppingCar.setShoppingCarId(shoppingCarId);
        if (shoppingCarService.updateShopNum(shoppingCar)){
            FastJson_All.toJson(true,response);
        }else{
            FastJson_All.toJson(false,response);
        }
    }

    //查找购物车的商品数量
    @RequestMapping("/countShoppings")
    public void countShop(int uId,HttpServletResponse response){
        FastJson_All.toJson(shoppingCarService.countShop(uId),response);
    }
    //delete
    @RequestMapping("/deleteShoppings")
    public void deleteShoppingCarGoods(Integer[] shoppingCarId,HttpServletResponse response){
        FastJson_All.toJson(shoppingCarService.deleteShoppingCarById(shoppingCarId),response);
    }

}
