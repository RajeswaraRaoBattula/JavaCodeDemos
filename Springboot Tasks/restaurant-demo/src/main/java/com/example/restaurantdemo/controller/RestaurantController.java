package com.example.restaurantdemo.controller;

import com.example.restaurantdemo.entity.Food;
import com.example.restaurantdemo.entity.Restaurant;
import com.example.restaurantdemo.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return service.createRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return service.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        service.deleteRestaurantById(id);
    }

    @PostMapping("/{id}/foods")
    public Food addFood(@PathVariable Long id, @Valid @RequestBody Food food) {
        return service.addFoodToRestaurant(id, food);
    }

    @DeleteMapping("/foods/{foodId}")
    public void deleteFood(@PathVariable Long foodId) {
        service.deleteFoodById(foodId);
    }
}
