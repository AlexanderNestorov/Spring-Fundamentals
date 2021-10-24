package com.example.exam24_10_21.service.category;

import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.CategoryNameEnum;
import com.example.exam24_10_21.repository.CategoryRepository;
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
                        case BATTLE -> category.setDescription("A battleship.");
                        case CARGO -> category.setDescription("A cargo ship");
                        case PATROL -> category.setDescription("A patrol ship");
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
