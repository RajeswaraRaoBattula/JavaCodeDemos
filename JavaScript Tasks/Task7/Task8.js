// Player 1 (Cricket)
const player1 = {
    name: "rohit Sharma",
    age: 36,
    sport: "Cricket",
    stats: {
        matches: 500,
        runs: 25000,
        average: 57.2
    }
};

// Player 2 (Football)
const player2 = {
    name: "Lionel Messi",
    age: 38,
    sport: "Football",
    stats: {
        matches: 800,
        goals: 720,
        assists: 300
    }
};

// Array of players
const players = [player1, player2];

// Function to print player details with sport-specific format
function printPlayer(player) {
    const { name, sport, stats } = player;

    console.log(`Player ${name} plays ${sport}.`);
    if (sport === "Cricket") {
        const { matches, runs, average } = stats;
        console.log(`Matches: ${matches} | Runs: ${runs} | Batting Average: ${average}`);
    } else if (sport === "Football") {
        const { matches, goals, assists } = stats;
        console.log(`Matches: ${matches} | Goals: ${goals} | Assists: ${assists}`);
    }
}

// Array destructuring
const [p1, p2] = players;

// Print both players
printPlayer(p1);
printPlayer(p2);
