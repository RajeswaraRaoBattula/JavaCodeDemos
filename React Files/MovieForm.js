import React, { Component } from "react";

// Define MovieForm class component
class MovieForm extends Component {
  constructor(props) {
    super(props); // Call parent constructor
    console.log("constructor executed"); // Lifecycle log

    // Initial component state
    this.state = {
      title: "",        // movie title
      director: "",     // director name
      year: "",         // release year
      genre: "Action",  // default genre
      rating: "",       // movie rating (1–5)
      description: "",  // movie description
      platforms: [],    // selected streaming platforms (checkbox)
      movies: [],       // list of added movies
      showForm: true    // toggle form visibility
    };
  }

  // Lifecycle method: runs before render, used to sync props to state
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // No state update needed here
  }

  // Lifecycle method: runs once after component mounts
  componentDidMount() {
    console.log("componentDidMount executed");
  }

  // Lifecycle method: decides if re-render should happen
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // Always allow re-render
  }

  // Lifecycle method: captures info before DOM updates
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null; // No snapshot needed
  }

  // Lifecycle method: runs after component updates
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  // Lifecycle method: runs just before component is removed
  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // Handle input changes (text, number, select, radio, checkbox)
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    // Special case: handle checkboxes (platforms array)
    if (type === "checkbox") {
      this.setState((prevState) => {
        const platforms = checked
          ? [...prevState.platforms, value] // add platform if checked
          : prevState.platforms.filter((p) => p !== value); // remove if unchecked
        return { platforms };
      });
    } else {
      // For text, number, select, radio → update by field name
      this.setState({ [name]: value });
    }
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent page reload

    // Destructure state values
    const { title, director, year, genre, rating, description, platforms } =
      this.state;

    // Create new movie object
    const newMovie = { title, director, year, genre, rating, description, platforms };

    // Update movies list and reset form fields
    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie], // add new movie to list
      title: "",
      director: "",
      year: "",
      genre: "Action", // reset genre
      rating: "",
      description: "",
      platforms: []
    }));
  };

  // Toggle form visibility
  toggleForm = () => {
    this.setState((prevState) => ({ showForm: !prevState.showForm }));
  };

  // Render method → defines UI
  render() {
    console.log("render executed"); // Lifecycle log

    // Destructure state variables for easy use
    const {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms,
      movies,
      showForm
    } = this.state;

    return (
      <div className="container mt-4">
        <h2 className="mb-3">🎬 Movie Form (Lifecycle Demo)</h2>

        {/* Button to toggle form visibility */}
        <button
          className="btn btn-secondary mb-3"
          onClick={this.toggleForm}
        >
          {showForm ? "Hide Form" : "Show Form"}
        </button>

        {/* Form section - visible only if showForm is true */}
        {showForm && (
          <div className="card p-4 mb-4">
            <form onSubmit={this.handleSubmit}>
              
              {/* Movie Title input */}
              <div className="mb-3">
                <label className="form-label">Movie Title</label>
                <input
                  type="text"
                  className="form-control"
                  name="title"
                  value={title}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Director input */}
              <div className="mb-3">
                <label className="form-label">Director</label>
                <input
                  type="text"
                  className="form-control"
                  name="director"
                  value={director}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Release Year input */}
              <div className="mb-3">
                <label className="form-label">Release Year</label>
                <input
                  type="number"
                  className="form-control"
                  name="year"
                  value={year}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Genre select dropdown */}
              <div className="mb-3">
                <label className="form-label">Genre</label>
                <select
                  className="form-control"
                  name="genre"
                  value={genre}
                  onChange={this.handleChange}
                >
                  <option>Action</option>
                  <option>Comedy</option>
                  <option>Drama</option>
                  <option>Sci-Fi</option>
                  <option>Horror</option>
                </select>
              </div>

              {/* Rating radio buttons */}
              <div className="mb-3">
                <label className="form-label">Rating</label>
                <div>
                  {[1, 2, 3, 4, 5].map((num) => (
                    <div className="form-check form-check-inline" key={num}>
                      <input
                        type="radio"
                        className="form-check-input"
                        name="rating"
                        value={num}
                        checked={rating === String(num)}
                        onChange={this.handleChange}
                      />
                      <label className="form-check-label">{num}</label>
                    </div>
                  ))}
                </div>
              </div>

              {/* Description textarea */}
              <div className="mb-3">
                <label className="form-label">Description</label>
                <textarea
                  className="form-control"
                  name="description"
                  value={description}
                  onChange={this.handleChange}
                ></textarea>
              </div>

              {/* Streaming platforms checkboxes */}
              <div className="mb-3">
                <label className="form-label">Streaming Platforms</label>
                <div>
                  {["Netflix", "Amazon Prime", "Disney+", "Others"].map(
                    (platform) => (
                      <div className="form-check form-check-inline" key={platform}>
                        <input
                          type="checkbox"
                          className="form-check-input"
                          value={platform}
                          checked={platforms.includes(platform)}
                          onChange={this.handleChange}
                        />
                        <label className="form-check-label">{platform}</label>
                      </div>
                    )
                  )}
                </div>
              </div>

              {/* Submit button */}
              <button type="submit" className="btn btn-primary">
                Add Movie
              </button>
            </form>
          </div>
        )}

        {/* Movies list - only shown if at least 1 movie added */}
        {movies.length > 0 && (
          <div>
            <h3>Movie List</h3>
            <table className="table table-bordered">
              <thead className="table-dark">
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Description</th>
                  <th>Platforms</th>
                </tr>
              </thead>
              <tbody>
                {movies.map((movie, index) => (
                  <tr key={index}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.year}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>{movie.description}</td>
                    <td>{movie.platforms.join(", ")}</td>
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

// Export component for use in other files
export default MovieForm;
