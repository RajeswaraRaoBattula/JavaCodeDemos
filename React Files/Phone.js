import React, { useState } from "react";

const Phone = () => {
  // useState hook to manage phone details
  const [phone, setPhone] = useState({
    brand: "Apple",
    model: "iPhone 14",
    price: 70000
  });

  // Function to update price
  const updatePrice = () => {
    setPhone({ ...phone, price: phone.price + 2500 });
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> ₹{phone.price}</p>
      <button
        onClick={updatePrice}
        style={{
          marginTop: "10px",
          padding: "10px 20px",
          fontSize: "16px",
          cursor: "pointer",
          backgroundColor:"lightblue",
          borderRadius:"10px"
        }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Phone;
