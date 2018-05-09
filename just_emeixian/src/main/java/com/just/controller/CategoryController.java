package com.just.controller;


import com.just.service.CategoryService;
import com.just.Util.FastJson_All;
import com.just.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by just on 2017/12/4.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/findFirstCates")
    public void findCategory(HttpServletResponse response) {
        List<Category> categoryList = categoryService.findChildCategory(0);
        FastJson_All.toJson(categoryList,response);
    }

    @RequestMapping("/findChildren")
    public void findCategory2(int cId,HttpServletResponse response) throws IOException {
        List<Category> SeccategoryList = categoryService.findChildCategory(cId);
        for(int i = 0;i<SeccategoryList.size();i++){
            List<Category> ThirdCat =  categoryService.findChildCategory(SeccategoryList.get(i).getcId());
            SeccategoryList.get(i).setCategoryList(ThirdCat);
        }
        FastJson_All.toJson(SeccategoryList,response);
    }


    @RequestMapping("deleCategory.do")
    public void deleCategoryId(Integer cid, HttpServletResponse response){
         Map maps = new HashMap();
         boolean result = categoryService.deletCategorys(cid);
         if (result){
             maps.put("success",result);
         }else {
             maps.put("error",result);
         }
        FastJson_All.toJson(maps,response);
    }



}
