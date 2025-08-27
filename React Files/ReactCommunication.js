// ReactCommunication.js
import React, { useState } from "react";

function ReactCommunication() {
  // Parent State
  const [fruits, setFruits] = useState(["Apple", "Mango"]);
  const [selectedFruit, setSelectedFruit] = useState("Mango");

  // Add fruit (Child B → Parent)
  const handleAddFruit = (newFruit) => {
    setFruits([...fruits, newFruit]);
  };

  // Select fruit (Child A → Parent)
  const handleSelectFruit = (fruit) => {
    setSelectedFruit(fruit);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>React Communication Example</h2>

      {/* Child A: List */}
      <FruitList fruits={fruits} onSelectFruit={handleSelectFruit} />

      {/* Child B: Sender */}
      <Sender onSendFruit={handleAddFruit} />

      {/* Child C: Selected Fruit */}
      <SelectedFruit selected={selectedFruit} />
    </div>
  );
}

// ---------------- Child A: FruitList ----------------
function FruitList({ fruits, onSelectFruit }) {
  return (
    <div style={{ border: "1px solid black", padding: "10px", margin: "10px" }}>
      <h3>Fruit List</h3>
      {fruits.map((fruit, index) => (
        <div
          key={index}
          style={{ cursor: "pointer" }}
          onClick={() => onSelectFruit(fruit)}
        >
          {fruit}
        </div>
      ))}
    </div>
  );
}

// ---------------- Child B: Sender ----------------
function Sender({ onSendFruit }) {
  return (
    <div style={{ border: "1px solid black", padding: "10px", margin: "10px" }}>
      <h3>Sender</h3>
      <button onClick={() => onSendFruit("Orange")}>Send Fruit</button>
    </div>
  );
}

// ---------------- Child C: SelectedFruit ----------------
function SelectedFruit({ selected }) {
  return (
    <div style={{ border: "1px solid black", padding: "10px", margin: "10px" }}>
      <h3>Selected Fruit</h3>
      <p>{selected}</p>
    </div>
  );
}

export default ReactCommunication;
