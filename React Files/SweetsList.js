import React from "react";

const SweetsList = () => {
  // Array of sweets as JSON objects
  const sweets = [
    { id: 1, name: "Gulab Jamun", price: 200 },
    { id: 2, name: "Rasgulla", price: 180 },
    { id: 3, name: "Kaju Katli", price: 500 },
    { id: 4, name: "Ladoo", price: 250 },
    { id: 5, name: "Jalebi", price: 150 }
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Sweets List</h2>
      {sweets.map((sweet) => (
        <div key={sweet.id} style={{ fontSize: "18px", margin: "5px 0" }}>
          {sweet.name} - Price: ₹{sweet.price}
        </div>
      ))}
    </div>
  );
};

export default SweetsList;
