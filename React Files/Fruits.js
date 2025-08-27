import React, { Component } from "react";

//Functional Component(Purely presentational): FruitList                                         

function FruitList({ fruits }) {
  return (
    <div>
     
      <h3>Fruit List:</h3>
      <ul>
        {fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>  //"key" helps React identify items between renders.
        ))}
      </ul>
    </div>
  );
}

class Fruits extends Component {
  constructor(props) {
    super(props); 

    this.state = {
      fruits: ["Apple", "Banana", "Mango"],
      newFruit: ""
    };
  }

  // Handle input changes. Called on every keystroke in the input.
  handleChange = (e) => {
    // Update "newFruit" in state to whatever the user typed.
    this.setState({ newFruit: e.target.value });
  };

  addFruit = () => {
    const { newFruit, fruits } = this.state;
    const trimmed = newFruit.trim();
    if (!trimmed) return;
    this.setState({
      fruits: [...fruits, trimmed],
      newFruit: ""
    });
  };

  // allow pressing Enter to add quickly
  handleKeyDown = (e) => {
    if (e.key === "Enter") this.addFruit();
  };

  render() {
    return (
      <div style={{ padding: "20px", maxWidth: 420 }}>
    
        <h2>Fruit Manager</h2>

     
        <input
          type="text"
          placeholder="Enter fruit name"
          value={this.state.newFruit}
          onChange={this.handleChange}
          onKeyDown={this.handleKeyDown} // Press Enter to add
          style={{ padding: "8px", width: "100%", boxSizing: "border-box" }}
        />

        {/* Button that triggers "addFruit" to push the new item */}
        <button
          onClick={this.addFruit}
          style={{ marginTop: "10px", padding: "8px 12px", cursor: "pointer" }}
        >
          Add
        </button>

        {/* Child: pass the current fruits array down as a prop */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

// Export the class component so App.js can import and render it.
export default Fruits;
