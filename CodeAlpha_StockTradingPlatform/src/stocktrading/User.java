package stocktrading;

public class User {

    private int userId;
    private String name;
    private double balance;

    private Portfolio portfolio;

    public User(
            int userId,
            String name,
            double balance) {

        this.userId = userId;
        this.name = name;
        this.balance = balance;

        // Every user gets a portfolio
        this.portfolio = new Portfolio();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    // Add money
    public void addMoney(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Deduct money
    public boolean deductMoney(double amount) {

        if (amount <= balance) {

            balance = balance - amount;

            return true;
        }

        return false;
    }

    // Add money from selling stock
    public void receiveMoney(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Display user information
    public void displayUser() {

        System.out.println("\n===== USER DETAILS =====");

        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Balance: ₹" + balance);
    }
}