import React, { Component } from "react";

function TelevisionList({ models }) {
  return (
    <div>
      <h3>Available Television Models:</h3>
      <ul>
        {models.map((model, index) => (
          <li key={index}>{model}</li>
        ))}
      </ul>
    </div>
  );
}

class TelevisionManager extends Component {
  constructor(props) {
    super(props);

    this.state = {
      models: ["Samsung QLED", "Sony Bravia", "LG OLED"],
      newModel: ""
    };
  }

  // Handle input changes (controlled component)
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });
  };

  // Add a new TV model to the list
  addModel = () => {
    const { newModel, models } = this.state;
    const trimmed = newModel.trim();

    if (!trimmed) return; // ignore empty entries

    // Spread operator (...) to keep existing models + add new one
    this.setState({
      models: [...models, trimmed],
      newModel: "" 
    });
  };

  render() {
    return (
      <div style={{ padding: "20px", maxWidth: "400px" }}>
        <h2>Television Manager</h2>

       
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange}
          placeholder="Enter TV model"
          style={{ padding: "8px", width: "100%", boxSizing: "border-box" }}
        />

        <button
          onClick={this.addModel}
          style={{
            marginTop: "10px",
            padding: "8px 12px",
            cursor: "pointer"
          }}
        >
          Add Model
        </button>

       
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

export default TelevisionManager;
