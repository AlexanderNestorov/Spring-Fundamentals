package com.example.examprep27_06.controller;

import com.example.examprep27_06.security.CurrentUser;
import com.example.examprep27_06.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
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
