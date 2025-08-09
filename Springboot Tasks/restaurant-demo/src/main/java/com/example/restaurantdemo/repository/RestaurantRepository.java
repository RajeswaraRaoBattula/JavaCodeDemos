package com.example.restaurantdemo.repository;

import com.example.restaurantdemo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
