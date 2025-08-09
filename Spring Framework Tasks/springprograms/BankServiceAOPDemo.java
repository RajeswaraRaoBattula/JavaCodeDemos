package springprograms;

public class BankServiceAOPDemo {
	
	private double balance = 0.0;

    public String deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
        return "New Balance: ₹" + balance;
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds");
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
        return "New Balance: ₹" + balance;
    }

    public String checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
        return "Balance: ₹" + balance;
    }


}
