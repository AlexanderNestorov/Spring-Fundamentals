package com.example.examprep27_06.controller;

import com.example.examprep27_06.model.binding.ProductAddBindingModel;
import com.example.examprep27_06.model.service.ProductServiceModel;
import com.example.examprep27_06.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        return "product-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel",productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",bindingResult);

            return "redirect:add";
        }

        productService.addProduct(modelMapper
                .map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable Long id) {
        productService.buyProduct(id);

        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyProduct() {
        productService.buyAllProducts();
        return "redirect:/";
    }


    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return  new ProductAddBindingModel();
    }

    @ModelAttribute
    public ProductServiceModel productServiceModel() {
        return new ProductServiceModel();
    }
}
