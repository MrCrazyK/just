package com.just.service.impl;

import com.just.service.BrandService;
import com.just.dao.BrandMapper;
import com.just.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by just on 2017/12/15.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public List<Brand> brandAndProduct(Integer bId) {

        List<Brand> brands=  brandMapper.brandAndProduct(bId);

        return brands;
    }
}
