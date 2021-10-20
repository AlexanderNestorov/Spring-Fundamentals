package com.example.examprep15_10.repository.order;

import com.example.examprep15_10.model.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByOrderByPriceDesc();
}
