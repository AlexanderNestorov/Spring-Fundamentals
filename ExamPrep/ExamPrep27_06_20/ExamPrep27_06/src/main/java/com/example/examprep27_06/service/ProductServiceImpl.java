package com.example.examprep27_06.service;

import com.example.examprep27_06.model.entity.Product;
import com.example.examprep27_06.model.service.ProductServiceModel;
import com.example.examprep27_06.repository.ProductRepository;
import com.example.examprep27_06.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        Product product  = modelMapper.map(productServiceModel, Product.class);

        product.setCategory(categoryService.findByCategoryNameEnum(productServiceModel.getCategory()));

        productRepository.save(product);

    }
}
