package com.example.exam24_10_21.model.binding;

import com.example.exam24_10_21.model.entity.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    @Size(min = 2, max = 10, message = "The name must be between 2 and 10 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive(message = "The power must be positive.")
    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    @Positive(message = "The health must be positive.")
    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull(message = "You must select the category.")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
