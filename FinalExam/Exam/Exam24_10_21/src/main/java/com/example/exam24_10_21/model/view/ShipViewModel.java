package com.example.exam24_10_21.model.view;

import com.example.exam24_10_21.model.entity.Category;
import com.example.exam24_10_21.model.entity.User;

import java.time.LocalDate;

public class ShipViewModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private Category category;
    private User user;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
