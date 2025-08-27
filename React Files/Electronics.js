import React, { useState } from "react";

const Electronics = () => {
  // multiple useState hooks
  const [name, setName] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(55000);

  // temp state to hold input value for brand
  const [newBrand, setNewBrand] = useState("");

  // function to update brand
  const updateBrand = () => {
    if (newBrand.trim() !== "") {
      setBrand(newBrand);
      setNewBrand(""); // clear input after updating
    } else {
      alert("Please enter a brand name!");
    }
  };

  // function to increase price
  const increasePrice = () => {
    setPrice(price + 5000);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> ₹{price}</p>

      {/* Input for updating brand */}
      <input
        type="text"
        placeholder="Enter new brand"
        value={newBrand}
        onChange={(e) => setNewBrand(e.target.value)}
        style={{ padding: "8px", marginRight: "10px" }}
      />
      <button
        onClick={updateBrand}
        style={{ margin: "5px", padding: "10px 15px", cursor: "pointer" }}
      >
        Update Brand
      </button>

      <br />

      <button
        onClick={increasePrice}
        style={{ margin: "10px", padding: "10px 15px", cursor: "pointer" }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Electronics;
