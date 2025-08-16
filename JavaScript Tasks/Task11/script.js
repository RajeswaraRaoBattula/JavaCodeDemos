function createPortfolio() {
    let portfolio = []; // Private array

    function log(msg) {
        document.getElementById("output").textContent += msg + "\n";
        console.log(msg);
    }

    function buyShare(company, qty, price) {
        portfolio.push({ company, qty, price });
        log(`Bought ${qty} shares of ${company} at ${price} each.₹`);
    }

    function sellShare(company, qty) {
        let found = portfolio.find(s => s.company === company);
        if (found) {
            if (found.qty >= qty) {
                found.qty -= qty;
                log(`Sold ${qty} shares of ${company}.`);
            } else {
                log(`Not enough shares of ${company} to sell.`);
            }
        } else {
            log(`${company} not found in portfolio.`);
        }
    }

    function totalValue() {
        let total = portfolio.reduce((sum, share) => sum + share.qty * share.price, 0);
        log(`Portfolio Value: ${total}₹`);
    }

    return { buyShare, sellShare, totalValue };
}

const portfolio = createPortfolio();
