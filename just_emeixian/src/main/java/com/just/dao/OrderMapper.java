package com.just.dao;


import com.just.entity.Order;

import java.util.List;

public interface OrderMapper {

    public Order selectOrderById(int oId);
    public List<Order> selectOrderForUser(int uId);
    public boolean addNewOrder(Order order);
    public boolean payOrder(int oId);
    public boolean deleteOrder(int oId);

//    public List<Order> findAllOrders();
}
