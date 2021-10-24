package com.example.exam24_10_21.controller;

import com.example.exam24_10_21.model.binding.AttackBindingModel;
import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.Ship;
import com.example.exam24_10_21.model.service.ShipServiceModel;
import com.example.exam24_10_21.model.view.ShipViewModel;
import com.example.exam24_10_21.security.CurrentUser;
import com.example.exam24_10_21.service.category.CategoryService;
import com.example.exam24_10_21.service.ship.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public HomeController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper, CategoryService categoryService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String index(Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

        List<ShipViewModel> ships = shipService.findAllShips();
        List<ShipViewModel> userShips = shipService.userShips(currentUser.getId());
        List<ShipViewModel> guestShips = shipService.guestShips(currentUser.getId());

        model.addAttribute("ships", ships);
        model.addAttribute("userShips", userShips);
        model.addAttribute("guestShips", guestShips);

        return "home";
    }

    @PostMapping("/fire")
    public String fire(@Valid AttackBindingModel attackBindingModel) {


        Ship defender = shipService.getShipByName(attackBindingModel.getDefender());
        Ship attacker = shipService.getShipByName(attackBindingModel.getAttacker());

        Category category = defender.getCategory();

        defender.setHealth(defender.getHealth() - attacker.getPower());

        if(defender.getHealth() <= 0) {
            shipService.deleteById(defender.getId());
            return "redirect:/";
        }

        shipService.updateShip(modelMapper.map(defender, ShipServiceModel.class), category);

        return "redirect:/";
    }

    @ModelAttribute
    public AttackBindingModel attackBindingModel() {
        return new AttackBindingModel();
    }
}
