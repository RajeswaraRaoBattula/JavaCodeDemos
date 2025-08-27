// Import React and necessary hooks
import React, { useState, useEffect } from "react";

function RestaurantForm() {
  // Define state for form fields
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",
    address: "",
    cuisineType: "",
    openingHours: ""
  });

  // Define state for submitted data (JSON)
  const [submittedData, setSubmittedData] = useState(null);

  // ------------------- useEffect Section -------------------

  //Run on every render
  useEffect(() => {
    console.log("RestaurantForm component rendered!");
  });

  //  Run only once (on mount)
  useEffect(() => {
    console.log("Welcome to Restaurant Registration 🏨");
  }, []);

  // Run whenever formData changes
  useEffect(() => {
    console.log("Form data changed:", formData);
  }, [formData]);

  //Auto-save form data every 5 seconds
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-saving form data:", formData);
      // In real-world, you might send formData to backend API here
    }, 5000);

    // Cleanup interval when component unmounts
    return () => clearInterval(interval);
  }, [formData]);

  // ------------------- Handlers -------------------

  // Handle input change (update state)
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent page refresh
    setSubmittedData(formData); // Store data as JSON
  };

  // ------------------- JSX UI -------------------

  return (
    <div style={{ maxWidth: "500px", margin: "20px auto", fontFamily: "Arial" }}>
      <h1>🍴 Restaurant Registration Form</h1>
      <p>Welcome to Restaurant Registration 🏨</p>

      {/* Form starts here */}
      <form onSubmit={handleSubmit}>
        <label>Restaurant Name</label>
        <input
          type="text"
          name="restaurantName"
          value={formData.restaurantName}
          onChange={handleChange}
        />
        <br />

        <label>Owner Name</label>
        <input
          type="text"
          name="ownerName"
          value={formData.ownerName}
          onChange={handleChange}
        />
        <br />

        <label>Email</label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
        />
        <br />

        <label>Contact Number</label>
        <input
          type="text"
          name="contact"
          value={formData.contact}
          onChange={handleChange}
        />
        <br />

        <label>Address</label>
        <input
          type="text"
          name="address"
          value={formData.address}
          onChange={handleChange}
        />
        <br />

        <label>Cuisine Type</label>
        <input
          type="text"
          name="cuisineType"
          value={formData.cuisineType}
          onChange={handleChange}
        />
        <br />

        <label>Opening Hours</label>
        <input
          type="text"
          name="openingHours"
          value={formData.openingHours}
          onChange={handleChange}
        />
        <br />

        <button type="submit">Submit</button>
      </form>

      {/* Display JSON after submission */}
      {submittedData && (
        <div style={{ marginTop: "20px" }}>
          <h3>📂 Submitted Data (JSON)</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default RestaurantForm;
