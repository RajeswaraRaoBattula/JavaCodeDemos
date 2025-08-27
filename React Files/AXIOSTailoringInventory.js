import React, { useEffect, useState } from "react";

// Import axios for making HTTP requests
import axios from "axios";

// Functional component
const TailoringInventory = () => {
  // Declare state variable "items" (array) and updater "setItems"
  const [items, setItems] = useState([]);

  // useEffect hook runs when component loads (empty dependency [])
  useEffect(() => {
    // Make GET request to JSON Server using axios
    axios.get("http://localhost:5000/tailoringItems")
      .then(response => {
        // If request successful, update items state with server data
        setItems(response.data);
      })
      .catch(error => {
        // If error occurs, log it to console
        console.error("Error fetching data:", error);
      });
  }, []); // Empty array → run only once when component mounts

  return (
    // Container with Bootstrap spacing (mt-4 = margin-top: 1.5rem)
    <div className="container mt-4">
      {/* Heading */}
      <h2 className="text-center mb-4">Tailoring Shop Inventory</h2>

      {/* Bootstrap styled table */}
      <table className="table table-bordered table-hover">
        {/* Table header */}
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Size</th>
            <th>Price (₹)</th>
          </tr>
        </thead>

        {/* Table body */}
        <tbody>
          {/* If items array has data, map through it */}
          {items.length > 0 ? (
            items.map(item => (
              <tr key={item.id}> {/* Each row needs a unique key */}
                <td>{item.id}</td>     {/* Show item id */}
                <td>{item.name}</td>   {/* Show item name */}
                <td>{item.size}</td>   {/* Show item size */}
                <td>{item.price}</td>  {/* Show item price */}
              </tr>
            ))
          ) : (
            // If no data yet, show "Loading..."
            <tr>
              <td colSpan="4" className="text-center">Loading...</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

// Export component so it can be used in App.js
export default TailoringInventory;
