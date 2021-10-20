package com.example.examprep15_10.service.order;

import com.example.examprep15_10.model.service.OrderServiceModel;
import com.example.examprep15_10.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDesc();

    void readyOrder(Long id);
}
