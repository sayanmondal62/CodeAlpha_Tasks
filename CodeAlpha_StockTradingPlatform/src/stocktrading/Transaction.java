package stocktrading;

import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime dateTime;

    public Transaction(
            String type,
            String stockSymbol,
            int quantity,
            double price) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.dateTime = LocalDateTime.now();
    }

    public void displayTransaction() {

        double totalAmount = quantity * price;

        System.out.println(
                type + " | " +
                stockSymbol + " | " +
                quantity + " shares | " +
                "₹" + price + " | " +
                "Total: ₹" + totalAmount + " | " +
                dateTime
        );
    }
}