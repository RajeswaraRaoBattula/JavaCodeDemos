import React from "react";

// Child component
// This component receives props
const CanteenItem = ({ name, price, category, available }) => {
  return (
    <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px", borderRadius: "8px" }}>
      <h3>{name}</h3>
      <p><strong>Price:</strong> ₹{price}</p>
      <p><strong>Category:</strong> {category}</p>
      <p><strong>Available:</strong> {available}</p>
    </div>
  );
};

export default CanteenItem;
