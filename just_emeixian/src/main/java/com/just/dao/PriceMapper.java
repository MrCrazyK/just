package com.just.dao;

import com.just.entity.Price;

public interface PriceMapper {

    public Price selectPriceByPriceId(int priceId);
    public Price selectPriceByThreeLimits(Price price);
    public boolean addPriceWithOutPriceName(Price price);
    public boolean addPriceName(Price price);
}
