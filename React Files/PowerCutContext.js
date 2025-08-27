import React, { createContext, useState } from "react"; 
// Import React and hooks: createContext (for context API), useState (for state management)

// Create a Context object
export const PowerCutContext = createContext();

// Create a Provider component that will wrap the app
export const PowerCutProvider = ({ children }) => {
  // announcements state holds all power cut messages
  const [announcements, setAnnouncements] = useState([]);

  // Function to add a new announcement
  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(), // unique id based on current timestamp
      street,         // street name
      message,        // power cut message
      time: new Date().toLocaleString() // current date & time as string
    };

    // Update announcements, putting the new one at the top
    setAnnouncements([newAnnouncement, ...announcements]);
  };

  return (
    // Provide announcements data and addAnnouncement function to children
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
};
