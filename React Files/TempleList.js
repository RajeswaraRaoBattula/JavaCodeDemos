import React from 'react';

const TempleList = () => {
  const temples = [
    {
      name: "Dhurgamma Temple",
      location: "Vijayawada, Andhra Pradesh",
      deities: ["Dhuramma", "Bhavani"],
    },
    {
      name: "Tirupati Balaji Temple",
      location: "Tirupati, Andhra Pradesh",
      deities: ["Lord Venkateswara"],
    },
    {
      name: "Jagannath Temple",
      location: "Puri, Odisha",
      deities: ["Jagannath", "Balabhadra", "Subhadra"],
    },
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Famous Temples in India</h1>
      <table style={{ borderCollapse: 'collapse', width: '100%' }} border="1">
        <thead>
          <tr>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple, index) => (
            <tr key={index}>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul>
                  {temple.deities.map((deity, i) => (
                    <li key={i}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList;
