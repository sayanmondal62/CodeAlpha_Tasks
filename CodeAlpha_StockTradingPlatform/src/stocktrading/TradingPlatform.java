package stocktrading;

import java.util.ArrayList;

public class TradingPlatform {

    private ArrayList<Stock> stocks;
    private ArrayList<Transaction> transactions;

    public TradingPlatform() {

        stocks = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add stock to market
    public void addStock(Stock stock) {

        stocks.add(stock);
    }

    // Display market
    public void displayMarket() {

        System.out.println("\n===== STOCK MARKET =====");

        if (stocks.isEmpty()) {

            System.out.println("No stocks available.");

            return;
        }

        for (Stock stock : stocks) {

            stock.displayStock();
        }
    }

    // Find stock by symbol
    public Stock findStock(String symbol) {

        for (Stock stock : stocks) {

            if (stock.getSymbol()
                    .equalsIgnoreCase(symbol)) {

                return stock;
            }
        }

        return null;
    }

    // BUY STOCK
    public void buyStock(
            User user,
            String symbol,
            int quantity) {

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than 0."
            );

            return;
        }

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found."
            );

            return;
        }

        double totalCost =
                stock.getPrice() * quantity;

        // Check balance
        if (!user.deductMoney(totalCost)) {

            System.out.println(
                    "Insufficient balance."
            );

            return;
        }

        // Add shares to portfolio
        user.getPortfolio().addStock(
                stock.getSymbol(),
                quantity
        );

        // Create transaction
        Transaction transaction =
                new Transaction(
                        "BUY",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        System.out.println(
                "\nStock purchased successfully!"
        );

        System.out.println(
                "Stock: " + stock.getSymbol()
        );

        System.out.println(
                "Quantity: " + quantity
        );

        System.out.println(
                "Total Cost: ₹" + totalCost
        );
    }

    // SELL STOCK
    public void sellStock(
            User user,
            String symbol,
            int quantity) {

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than 0."
            );

            return;
        }

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found."
            );

            return;
        }

        // Check portfolio
        int ownedQuantity =
                user.getPortfolio()
                        .getQuantity(symbol);

        if (ownedQuantity < quantity) {

            System.out.println(
                    "You do not have enough shares."
            );

            System.out.println(
                    "You own: " +
                    ownedQuantity +
                    " shares"
            );

            return;
        }

        double totalAmount =
                stock.getPrice() * quantity;

        // Remove shares
        user.getPortfolio().removeStock(
                symbol,
                quantity
        );

        // Add money to balance
        user.receiveMoney(totalAmount);

        // Create transaction
        Transaction transaction =
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        System.out.println(
                "\nStock sold successfully!"
        );

        System.out.println(
                "Stock: " + stock.getSymbol()
        );

        System.out.println(
                "Quantity: " + quantity
        );

        System.out.println(
                "Total Amount: ₹" + totalAmount
        );
    }

    // Display transaction history
    public void displayTransactions() {

        System.out.println(
                "\n===== TRANSACTION HISTORY ====="
        );

        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions yet."
            );

            return;
        }

        for (Transaction transaction :
                transactions) {

            transaction.displayTransaction();
        }
    }
}