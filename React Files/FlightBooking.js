import React from "react";

// CONTROLLED COMPONENT (CLASS)
class FlightBookingControlled extends React.Component {
  constructor(props) {
    super(props);
    // Initialize state for controlled form inputs
    this.state = {
      passengerName: "",
      email: "",
      gender: "Male", // default gender
      meal: "Veg",    // default meal preference
      specialRequest: "",
      bookings: [],   // stores submitted bookings
    };
  }

  // Handle input changes: updates state whenever user types/selects
  handleChange = (e) => {
    const { name, value } = e.target;   // Extract field name and value
    this.setState({ [name]: value });   // Dynamically update matching state property
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault();  // Prevent page reload

    const { passengerName, email, gender, meal, specialRequest, bookings } = this.state;

    // Create a new booking row
    const newRow = {
      id: Date.now(),  // Unique id
      passengerName,
      email,
      gender,
      meal,
      specialRequest,
    };

    // Update state: add new booking + reset form fields
    this.setState({
      bookings: [...bookings, newRow],
      passengerName: "",
      email: "",
      gender: "Male",
      meal: "Veg",
      specialRequest: "",
    });
  };

  render() {
    const { passengerName, email, gender, meal, specialRequest, bookings } = this.state;

    return (
      <div className="card shadow-sm mb-4">
        <div className="card-body">
          <h2 className="h5 mb-3">Controlled Flight Booking Form</h2>

          {/* Controlled form: all inputs linked to state */}
          <form onSubmit={this.handleSubmit} className="row g-3">
            {/* Passenger Name */}
            <div className="col-md-6">
              <label className="form-label">Passenger Name</label>
              <input
                type="text"
                className="form-control"
                name="passengerName"
                value={passengerName}   // controlled value
                onChange={this.handleChange} // update state
                required
              />
            </div>

            {/* Email */}
            <div className="col-md-6">
              <label className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                name="email"
                value={email}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Gender - Radio Buttons */}
            <div className="col-md-6">
              <label className="form-label d-block">Gender</label>
              <div className="form-check form-check-inline">
                <input
                  className="form-check-input"
                  type="radio"
                  name="gender"
                  value="Male"
                  checked={gender === "Male"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Male</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  className="form-check-input"
                  type="radio"
                  name="gender"
                  value="Female"
                  checked={gender === "Female"}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Female</label>
              </div>
            </div>

            {/* Meal Preference - Dropdown */}
            <div className="col-md-6">
              <label className="form-label">Meal Preference</label>
              <select
                className="form-select"
                name="meal"
                value={meal}
                onChange={this.handleChange}
              >
                <option value="Veg">Veg</option>
                <option value="Non-Veg">Non-Veg</option>
              </select>
            </div>

            {/* Special Request - Textarea */}
            <div className="col-12">
              <label className="form-label">Special Request</label>
              <textarea
                className="form-control"
                rows={3}
                name="specialRequest"
                value={specialRequest}
                onChange={this.handleChange}
              />
            </div>

            {/* Submit Button */}
            <div className="col-12">
              <button type="submit" className="btn btn-primary">Add Booking</button>
            </div>
          </form>
        </div>

        {/* Display submitted bookings as table */}
        {bookings.length > 0 && (
          <div className="table-responsive px-3 pb-3">
            <table className="table table-striped table-bordered mb-0">
              <thead className="table-light">
                <tr>
                  <th>#</th>
                  <th>Passenger Name</th>
                  <th>Email</th>
                  <th>Gender</th>
                  <th>Meal</th>
                  <th>Special Request</th>
                </tr>
              </thead>
              <tbody>
                {bookings.map((b, idx) => (
                  <tr key={b.id}>
                    <td>{idx + 1}</td>
                    <td>{b.passengerName}</td>
                    <td>{b.email}</td>
                    <td>{b.gender}</td>
                    <td>{b.meal}</td>
                    <td>{b.specialRequest || "—"}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}


// UNCONTROLLED COMPONENT (CLASS)
class FlightBookingUncontrolled extends React.Component {
  constructor(props) {
    super(props);

    // Create refs for accessing DOM inputs directly
    this.flightNumberRef = React.createRef();
    this.sourceRef = React.createRef();
    this.destinationRef = React.createRef();
    this.travelDateRef = React.createRef();
    this.termsRef = React.createRef();

    // Local state only for error handling + showing submission
    this.state = { lastSubmission: null, error: "" };
  }

  handleSubmit = (e) => {
    e.preventDefault();

    // Access form values directly using refs
    const payload = {
      flightNumber: this.flightNumberRef.current.value,
      source: this.sourceRef.current.value,
      destination: this.destinationRef.current.value,
      travelDate: this.travelDateRef.current.value,
      termsAccepted: this.termsRef.current.checked,
    };

    // Validation: must accept terms
    if (!payload.termsAccepted) {
      this.setState({ error: "Please accept terms." });
      return;
    }

    // Save submission and clear error
    this.setState({ lastSubmission: payload, error: "" });

    // Reset the form fields
    e.target.reset();
  };

  render() {
    const { lastSubmission, error } = this.state;

    return (
      <div className="card shadow-sm mb-4">
        <div className="card-body">
          <h2 className="h5 mb-3">Uncontrolled Flight Booking Form</h2>

          {/* Uncontrolled form: uses refs instead of state */}
          <form onSubmit={this.handleSubmit} className="row g-3">
            <div className="col-md-6">
              <label className="form-label">Flight Number</label>
              <input type="text" className="form-control" ref={this.flightNumberRef} required />
            </div>
            <div className="col-md-6">
              <label className="form-label">Source</label>
              <input type="text" className="form-control" ref={this.sourceRef} required />
            </div>
            <div className="col-md-6">
              <label className="form-label">Destination</label>
              <input type="text" className="form-control" ref={this.destinationRef} required />
            </div>
            <div className="col-md-6">
              <label className="form-label">Travel Date</label>
              <input type="date" className="form-control" ref={this.travelDateRef} required />
            </div>
            <div className="col-12">
              <div className="form-check">
                <input className="form-check-input" type="checkbox" ref={this.termsRef} />
                <label className="form-check-label">Accept Terms</label>
              </div>
              {/* Show validation error */}
              {error && <div className="form-text text-danger">{error}</div>}
            </div>
            <div className="col-12">
              <button type="submit" className="btn btn-success">Submit</button>
            </div>
          </form>
        </div>

        {/* Show last submission */}
        {lastSubmission && (
          <div className="card m-3 border-success">
            <div className="card-header bg-success text-white">Latest Submission</div>
            <div className="card-body">
              <p><b>Flight #:</b> {lastSubmission.flightNumber}</p>
              <p><b>From:</b> {lastSubmission.source}</p>
              <p><b>To:</b> {lastSubmission.destination}</p>
              <p><b>Date:</b> {lastSubmission.travelDate}</p>
            </div>
          </div>
        )}
      </div>
    );
  }
}


// EXPORT BOTH FOR APP

export default function FlightBooking() {
  return (
    <div className="container py-4">
      <div className="row">
        {/* Controlled form on left */}
        <div className="col-lg-6">
          <FlightBookingControlled />
        </div>

        {/* Uncontrolled form on right */}
        <div className="col-lg-6">
          <FlightBookingUncontrolled />
        </div>
      </div>
    </div>
  );
}
