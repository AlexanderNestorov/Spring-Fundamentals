package com.example.examprep15_10.controller;

import com.example.examprep15_10.security.CurrentUser;
import com.example.examprep15_10.service.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;

    public HomeController(CurrentUser currentUser, OrderService orderService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
    }

    @GetMapping()
    public String index(Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("orders", orderService.findAllOrdersByPriceDesc());

        return "home";
    }
}
