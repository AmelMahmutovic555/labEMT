package com.example.labemt.web;

import com.example.labemt.model.Food;
import com.example.labemt.service.domain.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> findAll(){
        return foodService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        return foodService.addFood(food).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
