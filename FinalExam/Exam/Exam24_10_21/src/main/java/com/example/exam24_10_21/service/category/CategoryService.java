package com.example.exam24_10_21.service.category;

import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
