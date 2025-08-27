import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class MarriageForm extends Component {
  constructor(props) {
    super(props);

    // Initialize state with empty fields
    this.state = {
      brideName: "",
      groomName: "",
      date: "",
      venue: "",
      submitted: false // To track if form is submitted
    };
  }

  // Generic handler for input changes
  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent page reload
    this.setState({ submitted: true });
  };

  render() {
    return (
      <div className="container mt-4">
        {/* Card for Form */}
        <div className="card p-4 shadow-sm">
          <h3 className="text-center mb-4">Marriage Form</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                name="brideName"
                className="form-control"
                value={this.state.brideName}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Groom Name */}
            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName"
                className="form-control"
                value={this.state.groomName}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Marriage Date */}
            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                name="date"
                className="form-control"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Venue */}
            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                className="form-control"
                value={this.state.venue}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Submit button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Display Submitted Details */}
        {this.state.submitted && (
          <div className="card p-4 mt-4 shadow-sm">
            <h3 className="text-center mb-3">Marriage Details</h3>
            <p>
              <strong>Bride Name:</strong> {this.state.brideName}
            </p>
            <p>
              <strong>Groom Name:</strong> {this.state.groomName}
            </p>
            <p>
              <strong>Date:</strong> {this.state.date}
            </p>
            <p>
              <strong>Venue:</strong> {this.state.venue}
            </p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
