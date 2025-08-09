package com.example.restaurantdemo.repository;

import com.example.restaurantdemo.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
