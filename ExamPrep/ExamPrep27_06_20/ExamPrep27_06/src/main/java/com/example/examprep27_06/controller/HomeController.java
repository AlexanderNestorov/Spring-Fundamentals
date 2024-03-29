package com.example.examprep27_06.controller;

import com.example.examprep27_06.model.view.ProductViewModel;
import com.example.examprep27_06.security.CurrentUser;
import com.example.examprep27_06.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

        List<ProductViewModel> products = productService.findAllProducts();

        model.addAttribute("products", products);
        model.addAttribute("totalPrice", products
                .stream()
                .map(ProductViewModel::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.valueOf(0))
        );

        return "home";
    }


}
