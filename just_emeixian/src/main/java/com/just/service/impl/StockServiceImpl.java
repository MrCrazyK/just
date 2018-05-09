package com.just.service.impl;

import com.just.service.StockService;
import com.just.dao.StockMapper;
import com.just.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by just on 2017/12/11.
 */
@Service("stockService")
public class StockServiceImpl implements StockService{
    @Autowired
    private StockMapper stockMapper;

    public boolean updateByOrder(Stock stock) {
        return stockMapper.updateByOrder(stock);
    }

    public boolean addStockByPriceId(Stock stock) {
        return stockMapper.addStockByPriceId(stock);
    }
//    public boolean addNewStock(Stock){
//
//    };

}
