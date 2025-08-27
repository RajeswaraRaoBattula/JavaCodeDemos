import React, { Component } from 'react';
import MenuItem from './MenuItem';

class Restaurant extends Component {
  render() {
    const restaurantDetails = {
      name: "Tasty Bites",
      location: "MG Road, Bangalore",
      openHours: "10:00 AM - 10:00 PM",
    };

    const menu = [
      { name: "Paneer Butter Masala", price: 250, category: "Main Course", available: true },
      { name: "Veg Biryani", price: 200, category: "Main Course", available: true },
      { name: "Gulab Jamun", price: 100, category: "Dessert", available: false },
      { name: "Masala Dosa", price: 120, category: "Breakfast", available: true },
    ];

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>{restaurantDetails.name}</h1>
        <p>Location: {restaurantDetails.location}</p>
        <p>Open Hours: {restaurantDetails.openHours}</p>
        <h2>Menu</h2>
        {menu.map((item, index) => (
          <MenuItem
            key={index}
            name={item.name}
            price={item.price}
            category={item.category}
            available={item.available}
          />
        ))}
      </div>
    );
  }
}

export default Restaurant;
