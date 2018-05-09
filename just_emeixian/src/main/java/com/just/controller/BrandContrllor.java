package com.just.controller;

import com.just.service.BrandService;
import com.just.Util.FastJson_All;
import com.just.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by just on 2017/12/15.
 */
@Controller
@RequestMapping("brand")
public class BrandContrllor {
    @Autowired
    private BrandService brandService;

    @RequestMapping("brand.do")
    public void findBrands(Integer bId, HttpServletResponse response){

        Map maps = new HashMap();
        List<Brand> brandList = brandService.brandAndProduct(bId);
        if (brandList.size()!= 0){
            maps.put("success",brandList);
        }else {

            maps.put("error",brandList);
        }

        FastJson_All.toJson(maps,response);


    }

}
