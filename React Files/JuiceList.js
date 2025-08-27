import React from "react";
import Juice from "./Juice";

const JuiceList = () => {
  // Array of juice objects
  const juices = [
    { id: 1, name: "Mango Juice", price: 50 },
    { id: 2, name: "Orange Juice", price: 40 },
    { id: 3, name: "Apple Juice", price: 60 },
    { id: 4, name: "Pineapple Juice", price: 70 },
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Juice Menu</h2>
      <table border="1" cellPadding="10" style={{ margin: "auto", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
