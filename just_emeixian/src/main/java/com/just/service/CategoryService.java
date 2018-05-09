package com.just.service;

import com.just.entity.Category;

import java.util.List;

/**
 * Created by just on 2017/12/4.
 */
public interface CategoryService {



    public List<Category> findChildCategory(Integer cId);

   // public boolean updateLbtUrl(Category category);

    //后台删除
    public Boolean deletCategorys(Integer cid);

}
