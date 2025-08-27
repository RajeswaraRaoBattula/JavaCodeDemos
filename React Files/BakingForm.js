import React, { useState } from "react";


const BakingForm = () => {
  // State for form fields
  const [formData, setFormData] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake", // default
  });

  // State for submitted items list
  const [bakingItems, setBakingItems] = useState([]);

  // Handle input changes (for all fields)
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  // Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();

    // Add formData into bakingItems array
    setBakingItems([...bakingItems, formData]);

    // Reset form
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake",
    });
  };

  return (
    <div className="container mt-4">
      {/* Card for form */}
      <div className="card p-4 shadow-sm">
        <h3 className="text-center mb-4">Baking Items Form</h3>
        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="form-group mb-3">
            <label>Item Name</label>
            <input
              type="text"
              name="itemName"
              className="form-control"
              value={formData.itemName}
              onChange={handleChange}
              required
            />
          </div>

          {/* Quantity */}
          <div className="form-group mb-3">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              className="form-control"
              value={formData.quantity}
              onChange={handleChange}
              required
            />
          </div>

          {/* Ingredients */}
          <div className="form-group mb-3">
            <label>Ingredients</label>
            <textarea
              name="ingredients"
              className="form-control"
              rows="3"
              value={formData.ingredients}
              onChange={handleChange}
              required
            ></textarea>
          </div>

          {/* Baking Time */}
          <div className="form-group mb-3">
            <label>Baking Time (minutes)</label>
            <input
              type="number"
              name="bakingTime"
              className="form-control"
              value={formData.bakingTime}
              onChange={handleChange}
              required
            />
          </div>

          {/* Category */}
          <div className="form-group mb-3">
            <label>Category</label>
            <select
              name="category"
              className="form-control"
              value={formData.category}
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn btn-primary w-100">
            Add Baking Item
          </button>
        </form>
      </div>

      {/* Display Table */}
      {bakingItems.length > 0 && (
        <div className="card p-4 mt-4 shadow-sm">
          <h3 className="text-center mb-3">Baking Items List</h3>
          <table className="table table-bordered table-striped">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time (min)</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {bakingItems.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default BakingForm;
