package com.just.service.impl;

import com.just.service.PriceService;
import com.just.dao.PriceMapper;
import com.just.dao.SpecMapper;
import com.just.dao.UnitMapper;
import com.just.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by just on 2017/12/8.
 */
@Service("priceService")
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private SpecMapper specMapper;
    @Autowired
    private UnitMapper unitMapper;

    public Price findPriceLimited(Price price) {
        return priceMapper.selectPriceByThreeLimits(price);
    }
    @Transactional
    public boolean addTagsToPrice(Price price){
        price.setSpec(specMapper.selectSpecById(price.getSpec().getSpecId()));
        price.setUnit(unitMapper.selectUnitById(price.getUnit().getUnitId()));
        return priceMapper.addPriceWithOutPriceName(price);
    }
    public boolean addSpecToProduct(Price price){
        return specMapper.takeSpecToProduct(price);
    }
    public boolean addUnitToProduct(Price price){
        return unitMapper.takeUnitToProduct(price);
    }

    public boolean addPriceName(Price price) {
        return priceMapper.addPriceName(price);
    }
}
