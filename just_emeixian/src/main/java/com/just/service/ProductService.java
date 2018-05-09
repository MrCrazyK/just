package com.just.service;

import com.just.entity.Price;
import com.just.entity.Product;
import com.just.entity.Spec;
import com.just.entity.Unit;

import java.util.List;
import java.util.Map;

/**
 * Created by just on 2017/12/5.
 */
public interface ProductService {

    public List<Product> findsProducts(int parendId);
    public boolean updateProductDetail(Product product);
    public boolean addNewProduct(Product product);

    public Map<String,List> findAllTags();

    public boolean addNewUnit(Unit unit);
    public boolean addNewSpec(Spec spec);

    public Product selectProduct(Integer pId);
    public Double selectPrice(Price price);

}
