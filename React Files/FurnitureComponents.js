import React, { useState } from "react";

// Define a React functional component called "Chair"
const Chair = ({ details }) => (  // "details" is destructured from props
  <div>
    <h2>Chair</h2>
    <p>Name: {details.name}</p>
    <p>Price: ₹{details.price}</p>
    <p>Material: {details.material}</p>
    <p>Size: {details.size}</p>
    <p>Brand: {details.brand}</p>
  </div>
);

// Table Component
const Table = ({ details }) => (
  <div>
    <h2>Table</h2>
    <p>Name: {details.name}</p>
    <p>Price: ₹{details.price}</p>
    <p>Material: {details.material}</p>
    <p>Size: {details.size}</p>
    <p>Brand: {details.brand}</p>
  </div>
);

// Sofa Component
const Sofa = ({ details }) => (
  <div>
    <h2>Sofa</h2>
    <p>Name: {details.name}</p>
    <p>Price: ₹{details.price}</p>
    <p>Material: {details.material}</p>
    <p>Size: {details.size}</p>
    <p>Brand: {details.brand}</p>
  </div>
);

// Bed Component
const Bed = ({ details }) => (
  <div>
    <h2>Bed</h2>
    <p>Name: {details.name}</p>
    <p>Price: ₹{details.price}</p>
    <p>Material: {details.material}</p>
    <p>Size: {details.size}</p>
    <p>Brand: {details.brand}</p>
  </div>
);

// ------------------ Main Furniture Component ------------------ //
export default function FurnitureComponents() {
  // State to track which furniture is selected from dropdown
  const [selected, setSelected] = useState("Chair");

  // Example data for each furniture item
  const furnitureData = {
    Chair: { name: "Dining Chair", price: 2000, material: "Wood", size: "Medium", brand: "IKEA" },
    Table: { name: "Coffee Table", price: 5000, material: "Glass", size: "Large", brand: "HomeTown" },
    Sofa: { name: "Recliner Sofa", price: 25000, material: "Leather", size: "Large", brand: "Godrej" },
    Bed: { name: "Queen Bed", price: 30000, material: "Teak Wood", size: "King Size", brand: "Durian" },
  };

  // Function to render the component based on selected furniture
  const renderFurniture = () => {
    switch (selected) {
      case "Chair":
        return <Chair details={furnitureData.Chair} />;
      case "Table":
        return <Table details={furnitureData.Table} />;
      case "Sofa":
        return <Sofa details={furnitureData.Sofa} />;
      case "Bed":
        return <Bed details={furnitureData.Bed} />;
      default:
        return <p>Select a furniture item</p>;
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Furniture Store</h1>

      {/* Dropdown to select furniture */}
      <select value={selected} onChange={(e) => setSelected(e.target.value)}>
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      {/* Render the selected furniture details */}
      <div style={{ marginTop: "20px" }}>{renderFurniture()}</div>
    </div>
  );
}
