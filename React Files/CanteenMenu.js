import React from "react";
import CanteenItem from "./CanteenItem";

// Parent component
const CanteenMenu = () => {
  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h1>Campus Canteen</h1>
      <p><strong>Location:</strong> Block A, Ground Floor</p>
      <p><strong>Open Hours:</strong> 8:00 AM - 8:00 PM</p>
      <hr />

      <h2>Menu</h2>
      <div style={{ display: "flex", justifyContent: "center", flexWrap: "wrap" }}>
        <CanteenItem name="Idli" price={40} category="Breakfast" available="Yes" />
        <CanteenItem name="Veg Thali" price={120} category="Lunch" available="Yes" />
        <CanteenItem name="Samosa" price={20} category="Snack" available="No" />
        <CanteenItem name="Paneer Roll" price={80} category="Snack" available="Yes" />
      </div>
    </div>
  );
};

export default CanteenMenu;
