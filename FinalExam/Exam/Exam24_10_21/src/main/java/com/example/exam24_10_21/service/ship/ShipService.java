package com.example.exam24_10_21.service.ship;

import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.Ship;
import com.example.exam24_10_21.model.service.ShipServiceModel;
import com.example.exam24_10_21.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {

    void addShip(ShipServiceModel shipServiceModel);
    void updateShip(ShipServiceModel shipServiceModel, Category category);

    List<ShipViewModel> findAllShips();

    List<ShipViewModel> userShips(Long id);

    List<ShipViewModel> guestShips(Long id);

    Ship getShipByName(String name);

    void deleteById(Long id);
}
