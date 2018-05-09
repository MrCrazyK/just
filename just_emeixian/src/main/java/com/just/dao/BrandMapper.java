package com.just.dao;

import com.just.entity.Brand;

import java.util.List;

/**
 * Created by lanou on 2017/12/15.
 */
    public  interface BrandMapper {

    public List<Brand> brandAndProduct(Integer bId);

}
