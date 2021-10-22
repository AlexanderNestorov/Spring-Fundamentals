package com.example.examprep27_06.service;

import com.example.examprep27_06.model.entity.Category;
import com.example.examprep27_06.model.entity.CategoryNameEnum;
import com.example.examprep27_06.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case Food -> category.setDescription("Food item");
                        case Drink -> category.setDescription("Beverage");
                        case Household -> category.setDescription("House utensils");
                        case Other -> category.setDescription("Miscellaneous");
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
