import React, { useContext } from "react"; 
// useContext → to read data from context

import { PowerCutContext } from "./PowerCutContext"; 
// Import context

const AnnouncementList = () => {
  const { announcements } = useContext(PowerCutContext); 
  // Get announcements array from context

  return (
    <div className="card p-3">
      <h4 className="mb-3">Announcements</h4>

      {/* Scrollable div for announcements */}
      <div style={{ maxHeight: "300px", overflowY: "auto" }}>
        
        {/* If no announcements */}
        {announcements.length === 0 ? (
          <p>No announcements yet.</p>
        ) : (
          // Loop through each announcement
          announcements.map((a) => (
            <div
              key={a.id} // unique key for each item
              className="border p-2 rounded mb-2 bg-light"
            >
              {/* Show announcement details */}
              <strong>Street:</strong> {a.street} <br />
              <strong>Message:</strong> {a.message} <br />
              <small className="text-muted">Time: {a.time}</small>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default AnnouncementList; // Export component
