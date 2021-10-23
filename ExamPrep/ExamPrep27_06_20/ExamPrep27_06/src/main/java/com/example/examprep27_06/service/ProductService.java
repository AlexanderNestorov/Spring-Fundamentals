package com.example.examprep27_06.service;

import com.example.examprep27_06.model.service.ProductServiceModel;
import com.example.examprep27_06.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProducts();

    void buyProduct(Long id);

    void buyAllProducts();
}
