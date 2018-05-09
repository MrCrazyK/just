package com.just.dao;
import com.just.entity.Category;

import java.util.List;
public interface CategoryMapper {

        public List<Category> selectCategoryChildrenByParentId(Integer cId);

        // public boolean updateLbtUrl(Category category);

        public Boolean deletCategory(Integer cid);
}
