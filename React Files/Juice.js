import React from "react";

// Child component → represents a single row in the table
const Juice = ({ id, name, price }) => {
  return (
    <tr>
      <td>{id}</td>
      <td>{name}</td>
      <td>₹{price}</td>
    </tr>
  );
};

export default Juice;
