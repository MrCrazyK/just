package com.just.service;

import com.just.entity.Order;

import java.util.List;

/**
 * Created by just on 2017/12/7.
 */
public interface OrderService {
    public Order selectOrderById(int oId);
    public List<Order> findOrdersForUser(int uId);
    public boolean addNewOrder(Order order);
    public boolean payOrder(int oId);
    public boolean deleteOrder(int oId);
}
