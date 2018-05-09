package com.just.service.impl;

import com.just.entity.*;
import com.just.service.ProductService;
import com.just.dao.ProductMapper;
import com.just.dao.SpecMapper;
import com.just.dao.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by just on 2017/12/5.
 */

@Service("ProdcutService")

public class ProductServiceImpl implements ProductService{

    @Autowired private  ProductMapper productMapper;

    @Autowired
    private SpecMapper specMapper;
    @Autowired
    private UnitMapper unitMapper;

    public List<Product> findsProducts(int parendId) {

        List<Product> Products = productMapper.findsProduct(parendId);

        return Products;

    }

    public boolean updateProductDetail(Product product) {
        return productMapper.updateProductDetail(product);
    }

    public boolean addNewProduct(Product product){
        return productMapper.addNewProduct(product);
    }

    public Map<String,List> findAllTags(){
            Map<String,List> tags = new HashMap<String, List>();
            List<Spec> specs = specMapper.selectAll();
            List<Unit> units = unitMapper.selectAll();
            tags.put("specs",specs);
            tags.put("unit",units);
            return tags;
    }

    public boolean addNewUnit(Unit unit){
       return unitMapper.addNewUnit(unit);
    }
    public boolean addNewSpec(Spec spec){
        return specMapper.addNewSpec(spec);
    }

    public Product selectProduct(Integer pId) {
        Product product= productMapper.selectProduct(pId);
//        List<Integer> unit=  productMapper.selectUnitId(pId);
        //System.out.println("dhdhdh"+unit);
//        List<Unit> units=new ArrayList<Unit>();
//        for (int i=0;i<unit.size();i++){
//            //System.out.println(unit.get(i));
//            Unit unit1 = productMapper.selectUnit(unit.get(i));
//            units.add(unit1);
//        }
//        //System.out.println("ghjmk"+units);
//        List<Integer> Spec1 =  productMapper.selectSpecId(pId);
//        //System.out.println("fghjk"+Spec1);
//        List<Spec> sPecs = new ArrayList<Spec>();
//        for (int i = 0;i < Spec1.size();i++){
//            System.out.println("uuuuuuuuuuuuuuu"+Spec1.get(i));
//            Spec spec= productMapper.selectSpec(Spec1.get(i));
//            sPecs.add(spec);
//        }
//        System.out.println(sPecs);
//
//        //Stock stock = productMapper.selectStock(pId);
//        detailsProduct.setSpecs(sPecs);
//        detailsProduct.setUnits(units);
//        //System.out.println(details);
        return product;
    }
    public  Double selectPrice(Price price){
        return  productMapper.selectPrice(price);
    };
}
