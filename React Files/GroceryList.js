import React from "react";

const GroceryList = ({ items }) => {
  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      
      <h2>Grocery List</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {/* Loop through the 'items' array using map() */}
        {items.map((item, index) => (
          <li key={index} style={{ margin: "5px 0", fontSize: "18px" }}>
            {item} 
          </li>
        ))}
      </ul>

      <button
        onClick={() => alert("Groceries Added to Cart!")} // Click event
        style={{
          marginTop: "10px",   
          padding: "10px 20px",
          fontSize: "16px",    
          cursor: "pointer",   
        }}
      >
        Add to Cart
      </button>
    </div>
  );
};


export default GroceryList;
