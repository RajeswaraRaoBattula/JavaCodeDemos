
package com.example.consumer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rides")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ride_id")
    private String rideId;

    @Column(name="driver_name")
    private String driverName;

    @Column(name="passenger_name")
    private String passengerName;

    @Column(name="pickup_location")
    private String pickupLocation;

    @Column(name="drop_location")
    private String dropLocation;

    @Column(name="fare")
    private Double fare;

    @Column(name="status")
    private String status;

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getRideId(){return rideId;}
    public void setRideId(String rideId){this.rideId=rideId;}
    public String getDriverName(){return driverName;}
    public void setDriverName(String driverName){this.driverName=driverName;}
    public String getPassengerName(){return passengerName;}
    public void setPassengerName(String passengerName){this.passengerName=passengerName;}
    public String getPickupLocation(){return pickupLocation;}
    public void setPickupLocation(String pickupLocation){this.pickupLocation=pickupLocation;}
    public String getDropLocation(){return dropLocation;}
    public void setDropLocation(String dropLocation){this.dropLocation=dropLocation;}
    public Double getFare(){return fare;}
    public void setFare(Double fare){this.fare=fare;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}
