
package com.example.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.consumer.entity.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
    Ride findByRideId(String rideId);
}
