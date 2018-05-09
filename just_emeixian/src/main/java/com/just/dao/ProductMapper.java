package com.just.dao;

import com.just.entity.*;

import java.util.List;

public interface ProductMapper {
    public List<Product> findsProduct(int parendId);
    public boolean updateProductDetail(Product product);
    public boolean addNewProduct(Product product);

    public Product selectProduct(Integer pId);
    //  public Spec selectSpec(Integer sPecId);
    //  public Stock selectStock(Integer stockId);
    public Unit selectUnit(Integer unit_id);
    public List<Integer> selectUnitId(Integer pId);
    public Spec selectSpec(Integer spec_id);
    public List<Integer> selectSpecId(Integer pId);
    public Stock selectStock(Integer pId);
    public Double selectPrice(Price price);
}
