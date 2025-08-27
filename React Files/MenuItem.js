import React, { Component } from 'react';

class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <div style={{ border: '1px solid #ccc', padding: '10px', margin: '5px', borderRadius: '5px' }}>
        <h3>{name}</h3>
        <p>Category: {category}</p>
        <p>Price: ₹{price}</p>
        <p>Status: {available ? 'Available' : 'Not Available'}</p>
      </div>
    );
  }
}

export default MenuItem;
