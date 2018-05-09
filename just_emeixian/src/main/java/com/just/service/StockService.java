package com.just.service;

import com.just.entity.Stock;

/**
 * Created by just on 2017/12/11.
 */
public interface StockService {
    public boolean updateByOrder(Stock stock);
    public boolean addStockByPriceId(Stock stock);
}
