package springpojos;

public class Account1 {
    private String number;
    private String holder;
    private double balance;
    private String type;

    // Setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Display method
    public void display() {
        System.out.println("Account Number: " + number);
        System.out.println("Account Holder: " + holder);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Type: " + type);
    }
}
