package com.example.examprep15_10.service.category;

import com.example.examprep15_10.model.entity.category.Category;
import com.example.examprep15_10.model.entity.category.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
