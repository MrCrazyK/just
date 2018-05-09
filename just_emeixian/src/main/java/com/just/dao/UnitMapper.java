package com.just.dao;

import com.just.entity.Price;
import com.just.entity.Unit;

import java.util.List;

/**
 * Created by just on 2017/12/7.
 */
public interface UnitMapper {
    public Unit selectUnitById(int priceId);
    public boolean takeUnitToProduct(Price price);
    public List<Unit> selectAll();
    public boolean addNewUnit(Unit unit);
    public List<Unit> selectUnitForProduct(int productId);
}
