// Import React and Component class
import React, { Component } from "react";

// Define AccessoriesForm component as a class
class AccessoriesForm extends Component {
  constructor(props) {
    super(props);

    // Initialize component state with default values
    this.state = {
      accessoryName: "",
      description: "",
      category: "Mobile", // default category
      brand: "",
      inStock: false,
      warranty: "",
      submitted: false
    };
  }

  // Update state when input fields (text, textarea, select, number) change
  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  // Update state when checkbox (inStock) changes
  handleCheckbox = (e) => {
    this.setState({ inStock: e.target.checked });
  };

  // Handle form submission and set submitted flag to true
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({ submitted: true });
  };

  // Render UI
  render() {
    return (
      <div className="container mt-4">
        {/* Bootstrap card for the form */}
        <div className="card p-4 shadow-sm">
          <h3 className="text-center mb-4">Accessories Form</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Text input for accessory name */}
            <div className="form-group mb-3">
              <label>Accessory Name</label>
              <input
                type="text"
                name="accessoryName"
                className="form-control"
                value={this.state.accessoryName}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Textarea input for description */}
            <div className="form-group mb-3">
              <label>Description</label>
              <textarea
                name="description"
                className="form-control"
                rows="3"
                value={this.state.description}
                onChange={this.handleChange}
                required
              ></textarea>
            </div>

            {/* Dropdown (select) for category */}
            <div className="form-group mb-3">
              <label>Category</label>
              <select
                name="category"
                className="form-control"
                value={this.state.category}
                onChange={this.handleChange}
              >
                <option value="Mobile">Mobile</option>
                <option value="Laptop">Laptop</option>
                <option value="Camera">Camera</option>
                <option value="Gaming">Gaming</option>
              </select>
            </div>

            {/* Radio buttons for brand selection */}
            <div className="form-group mb-3">
              <label>Brand</label>
              <div>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Samsung"
                    checked={this.state.brand === "Samsung"}
                    onChange={this.handleChange}
                    className="form-check-input"
                  />
                  <label className="form-check-label">Samsung</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Sony"
                    checked={this.state.brand === "Sony"}
                    onChange={this.handleChange}
                    className="form-check-input"
                  />
                  <label className="form-check-label">Sony</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Apple"
                    checked={this.state.brand === "Apple"}
                    onChange={this.handleChange}
                    className="form-check-input"
                  />
                  <label className="form-check-label">Apple</label>
                </div>
              </div>
            </div>

            {/* Checkbox to indicate stock availability */}
            <div className="form-group mb-3 form-check">
              <input
                type="checkbox"
                name="inStock"
                checked={this.state.inStock}
                onChange={this.handleCheckbox}
                className="form-check-input"
                id="inStockCheck"
              />
              <label className="form-check-label" htmlFor="inStockCheck">
                Available in Stock
              </label>
            </div>

            {/* Number input for warranty in years */}
            <div className="form-group mb-3">
              <label>Warranty (Years)</label>
              <input
                type="number"
                name="warranty"
                className="form-control"
                value={this.state.warranty}
                onChange={this.handleChange}
                min="0"
                max="10"
              />
            </div>

            {/* Submit button for the form */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Display submitted data in a Bootstrap table */}
        {this.state.submitted && (
          <div className="card p-4 mt-4 shadow-sm">
            <h3 className="text-center mb-3">Accessory Details</h3>
            <table className="table table-bordered">
              <tbody>
                <tr>
                  <th>Accessory Name</th>
                  <td>{this.state.accessoryName}</td>
                </tr>
                <tr>
                  <th>Description</th>
                  <td>{this.state.description}</td>
                </tr>
                <tr>
                  <th>Category</th>
                  <td>{this.state.category}</td>
                </tr>
                <tr>
                  <th>Brand</th>
                  <td>{this.state.brand}</td>
                </tr>
                <tr>
                  <th>Available in Stock</th>
                  <td>{this.state.inStock ? "Yes" : "No"}</td>
                </tr>
                <tr>
                  <th>Warranty</th>
                  <td>{this.state.warranty} years</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

// Export component so it can be used in other files
export default AccessoriesForm;
