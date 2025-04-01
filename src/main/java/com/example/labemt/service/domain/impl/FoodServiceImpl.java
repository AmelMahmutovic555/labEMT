package com.example.labemt.service.domain.impl;

import com.example.labemt.model.Food;
import com.example.labemt.repository.FoodRepository;
import com.example.labemt.service.domain.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @Override
    public List<Food> listAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> addFood(Food food) {
        return Optional.of(foodRepository.save(new Food(food.getFoodName(), food.getNumFood(), food.getPrice())));
    }
}
