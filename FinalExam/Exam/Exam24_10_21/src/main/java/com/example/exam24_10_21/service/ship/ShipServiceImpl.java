package com.example.exam24_10_21.service.ship;

import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.Ship;
import com.example.exam24_10_21.model.service.ShipServiceModel;
import com.example.exam24_10_21.model.view.ShipViewModel;
import com.example.exam24_10_21.repository.ShipRepository;
import com.example.exam24_10_21.security.CurrentUser;
import com.example.exam24_10_21.service.category.CategoryService;
import com.example.exam24_10_21.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship ship  = modelMapper.map(shipServiceModel, Ship.class);

        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        shipRepository.save(ship);
    }

    @Override
    public void updateShip(ShipServiceModel shipServiceModel, Category category) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setCategory(category);

        System.out.println(category);
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAll()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> userShips(Long id) {
        return shipRepository.findAllByUserWhereIdMatch(id)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> guestShips(Long id) {
        return shipRepository.findAllByUserWhereIdNotMatch(id)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Ship getShipByName(String name) {
        return shipRepository.findShipByName(name);
    }

    @Override
    public void deleteById(Long id) {
        shipRepository.deleteById(id);
    }
}
