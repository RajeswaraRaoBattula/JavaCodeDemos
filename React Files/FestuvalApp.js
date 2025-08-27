import React, { useEffect, useState } from "react";

function FestivalApp() {
  // Q3: festival state
  const [festival, setFestival] = useState("Diwali");

  // Q4: countdown state
  const [countdown, setCountdown] = useState(10);

  // Q1: Every render - no dependency array
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  // Q2: Run once on load - empty dependency array
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []);

  // Q3: Track festival changes
  useEffect(() => {
    console.log(`Festival changed to: ${festival}`);
  }, [festival]);

  // Q4: Countdown timer with cleanup
  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => prev - 1);
    }, 1000);

    // cleanup on unmount
    return () => {
      clearInterval(timer);
      console.log("Countdown timer cleared on unmount");
    };
  }, []);

  // Q5: Run when either festival or countdown changes
useEffect(() => {
  console.log(`Festival: ${festival}, Seconds left: ${countdown}`);
}, [festival, countdown]);
  return (
    <div>
      <h1>🎉 Festival App 🎉</h1>
      <h2>Current Festival: {festival}</h2>
      <h2>Countdown: {countdown}</h2>

      {/* Change festival */}
      <button onClick={() => setFestival("Holi")}>Holi</button>
      <button onClick={() => setFestival("Pongal")}>Pongal</button>
      <button onClick={() => setFestival("Diwali")}>Diwali</button>
    </div>
  );
}

export default FestivalApp;
