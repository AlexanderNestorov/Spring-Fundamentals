package com.example.exam24_10_21.controller;

import com.example.exam24_10_21.model.binding.ShipAddBindingModel;
import com.example.exam24_10_21.model.service.ShipServiceModel;
import com.example.exam24_10_21.service.ship.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel",shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",bindingResult);

            return "redirect:add";
        }

        shipService.addShip(modelMapper
                .map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }


    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return  new ShipAddBindingModel();
    }

    @ModelAttribute
    public ShipServiceModel shipServiceModel() {
        return new ShipServiceModel();
    }

}
