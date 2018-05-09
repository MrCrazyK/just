package com.just.service.impl;

import com.just.service.OrderService;
import com.just.dao.OrderMapper;
import com.just.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by just on 2017/12/7.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Transactional
    public Order selectOrderById(int oId) {
        return orderMapper.selectOrderById(oId);
    }

    public List<Order> findOrdersForUser(int uId) {
        return orderMapper.selectOrderForUser(uId);
    }

    public boolean addNewOrder(Order order){
        return orderMapper.addNewOrder(order);
    }

    public boolean payOrder(int oId) {
        return false;
    }
    public boolean deleteOrder(int oId) {
        return false;
    }
}
