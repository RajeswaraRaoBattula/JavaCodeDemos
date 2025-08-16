
package com.example.consumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import com.example.consumer.repository.RideRepository;
import com.example.consumer.entity.Ride;

@Component
public class RideKafkaListener {
    private final ObjectMapper mapper = new ObjectMapper();
    private final RideRepository repo;

    public RideKafkaListener(RideRepository repo){
        this.repo = repo;
    }

    @KafkaListener(topics = "uber-rides", groupId = "uber_ride_group")
    public void listen(String message) {
        try {
            Map<?,?> m = mapper.readValue(message, Map.class);
            String op = (String) m.get("operation");
            if ("CREATE".equalsIgnoreCase(op)) {
                Ride r = new Ride();
                r.setRideId(String.valueOf(m.get("id")));
                r.setDriverName((String)m.get("driverName"));
                r.setPassengerName((String)m.get("passengerName"));
                r.setPickupLocation((String)m.get("pickupLocation"));
                r.setDropLocation((String)m.get("dropLocation"));
                Object fare = m.get("fare");
                if (fare != null) r.setFare(Double.valueOf(String.valueOf(fare)));
                r.setStatus("CREATED");
                repo.save(r);
            } else if ("UPDATE".equalsIgnoreCase(op)) {
                String rideId = String.valueOf(m.get("id"));
                Ride existing = repo.findByRideId(rideId);
                if (existing != null) {
                    if (m.get("driverName")!=null) existing.setDriverName((String)m.get("driverName"));
                    if (m.get("passengerName")!=null) existing.setPassengerName((String)m.get("passengerName"));
                    if (m.get("fare")!=null) existing.setFare(Double.valueOf(String.valueOf(m.get("fare"))));
                    repo.save(existing);
                }
            } else if ("DELETE".equalsIgnoreCase(op)) {
                String rideId = String.valueOf(m.get("id"));
                Ride existing = repo.findByRideId(rideId);
                if (existing != null) repo.delete(existing);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
