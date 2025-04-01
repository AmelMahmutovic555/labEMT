package com.example.labemt.service.domain;

import com.example.labemt.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> listAll();
    Optional<Food> addFood(Food food);
}
