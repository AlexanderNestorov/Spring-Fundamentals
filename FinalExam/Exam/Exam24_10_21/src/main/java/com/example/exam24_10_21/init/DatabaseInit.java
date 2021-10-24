package com.example.exam24_10_21.init;

import com.example.exam24_10_21.service.category.CategoryService;
import com.example.exam24_10_21.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;

    public DatabaseInit(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
        userService.initUsers();
    }
}
