// 1. Declare building name using const
const buildingName = "Sunshine Apartments";

// 2. let variable for device status
let status = "OFF";

// Devices to control
const devices = ["Light", "Fan", "AC"];

// 3. var for loop counter
for (var i = 0; i < devices.length; i++) {
    // 4. Toggle the status
    status = (status === "OFF") ? "ON" : "OFF";

    console.log(`Checking Switch ${i + 1}: ${devices[i]} is ${status}`);
}

// 5. var counter is accessible outside loop
console.log(`Final value of loop counter i: ${i}`);

// 6. Try reassigning const (will cause error if uncommented)
// buildingName = "Moonlight Complex"; // ❌ TypeError: Assignment to constant variable.
