package com.example.restaurantdemo.service;

import com.example.restaurantdemo.entity.Food;
import com.example.restaurantdemo.entity.Restaurant;
import com.example.restaurantdemo.exception.ResourceNotFoundException;
import com.example.restaurantdemo.repository.FoodRepository;
import com.example.restaurantdemo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepo;
    private final FoodRepository foodRepo;

    public RestaurantService(RestaurantRepository restaurantRepo, FoodRepository foodRepo) {
        this.restaurantRepo = restaurantRepo;
        this.foodRepo = foodRepo;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
    }

    public void deleteRestaurantById(Long id) {
        if (!restaurantRepo.existsById(id)) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepo.deleteById(id);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        food.setRestaurant(restaurant);
        return foodRepo.save(food);
    }

    public void deleteFoodById(Long foodId) {
        if (!foodRepo.existsById(foodId)) {
            throw new ResourceNotFoundException("Food not found with id: " + foodId);
        }
        foodRepo.deleteById(foodId);
    }
}
