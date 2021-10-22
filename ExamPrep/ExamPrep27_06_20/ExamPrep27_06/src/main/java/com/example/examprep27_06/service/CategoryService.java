package com.example.examprep27_06.service;

import com.example.examprep27_06.model.entity.Category;
import com.example.examprep27_06.model.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
