// src/ReactFiles/FootballItems.js

import React, { useEffect, useState } from "react";   // Import React and hooks
import axios from "axios";                           // Import Axios for API calls
import 'bootstrap/dist/css/bootstrap.min.css';       // Import Bootstrap CSS

const FootballItems = () => {
  // State to hold football items
  const [items, setItems] = useState([]);

  // Fetch data from JSON Server when component loads
  useEffect(() => {
    axios.get("http://localhost:5000/footballItems")  // API endpoint
      .then(response => {
        setItems(response.data);  // Store data in state
      })
      .catch(error => {
        console.error("Error fetching data:", error); // Handle API errors
      });
  }, []); // Empty dependency → runs once after component mounts

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">⚽ Football Shop Inventory</h2>

      {/* Bootstrap styled table */}
      <table className="table table-bordered table-striped text-center">
        <thead className="thead-dark">
          <tr>
            <th>ID</th>
            <th>Item Name</th>
            <th>Brand</th>
            <th>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {/* Map through football items */}
          {items.map(item => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.brand}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FootballItems;
