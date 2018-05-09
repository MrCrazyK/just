package com.just.dao;

import com.just.entity.Price;
import com.just.entity.Spec;

import java.util.List;

/**
 * Created by just on 2017/12/7.
 */
public interface SpecMapper {
    public Spec selectSpecById(int priceId);
    public boolean takeSpecToProduct(Price price);
    public List<Spec> selectAll();
    public boolean addNewSpec(Spec spec);
    public List<Spec> selectSpecForProduct(int productId);
}
