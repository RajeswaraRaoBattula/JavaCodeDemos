import React, { useState, useContext } from "react"; 
// useState → manage form inputs
// useContext → access context data

import { PowerCutContext } from "./PowerCutContext"; 
// Import the PowerCutContext to use addAnnouncement

const SendAnnouncement = () => {
  const { addAnnouncement } = useContext(PowerCutContext); 
  // Access addAnnouncement function from context

  // Local state for form inputs
  const [street, setStreet] = useState("");   // stores street name
  const [message, setMessage] = useState(""); // stores announcement message

  // Function runs when form is submitted
  const handleSubmit = (e) => {
    e.preventDefault(); // prevent page reload

    // Validate inputs
    if (!street.trim() || !message.trim()) {
      alert("Both fields are required!"); // show alert if empty
      return;
    }

    // Call context function to add new announcement
    addAnnouncement(street, message);

    // Reset fields after submission
    setStreet("");
    setMessage("");
  };

  return (
    <div className="card p-3 mb-3">
      <h4 className="mb-3">Send Power Cut Announcement</h4>
      
      {/* Form to take input */}
      <form onSubmit={handleSubmit}>
        
        {/* Input for street name */}
        <input
          type="text"
          className="form-control mb-2"
          placeholder="Street Name"
          value={street}
          onChange={(e) => setStreet(e.target.value)}
        />

        {/* Input for message */}
        <textarea
          className="form-control mb-2"
          placeholder="Announcement Message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        ></textarea>

        {/* Submit button */}
        <button type="submit" className="btn btn-primary">
          Announce
        </button>
      </form>
    </div>
  );
};

export default SendAnnouncement; // Export component
