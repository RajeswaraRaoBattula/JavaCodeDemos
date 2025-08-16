const productInventory = (function () {
    let stock = 0; 

    return {
        getStock: function () {
            return stock;
        },
        addStock: function (quantity) {
            stock += quantity;
            console.log(`Stock after adding: ${stock}`);
        },
        sell: function (quantity) {
            if (quantity <= stock) {
                stock -= quantity;
                console.log(`Sold ${quantity} items.`);
            } else {
                console.log("Insufficient stock");
            }
        }
    };
})();

// Demonstration
productInventory.addStock(10);  // Adds 10 items
productInventory.sell(3);       // Sells 3 items
console.log(`Stock remaining: ${productInventory.getStock()}`);
