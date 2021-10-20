package com.example.examprep21_02.controller;

import com.example.examprep21_02.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping()
    public String index(Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

//        List<OrderViewModel> orders = orderService.findAllOrdersByPriceDesc();
//
//        model.addAttribute("orders", orders);
//        model.addAttribute("totalTime", orders
//                .stream()
//                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
//                .reduce(Integer::sum)
//                .orElse(0)
//        );
//
//        model.addAttribute("users", userService.findAllUsersAndOrderCountDesc());

        return "home";
    }
}
