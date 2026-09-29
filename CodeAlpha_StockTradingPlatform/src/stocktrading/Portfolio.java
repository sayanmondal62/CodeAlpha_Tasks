package stocktrading;

import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    // Add shares to portfolio
    public void addStock(String symbol, int quantity) {

        int currentQuantity = holdings.getOrDefault(symbol, 0);

        holdings.put(
                symbol,
                currentQuantity + quantity
        );
    }

    // Remove shares from portfolio
    public boolean removeStock(String symbol, int quantity) {

        int currentQuantity = holdings.getOrDefault(symbol, 0);

        if (currentQuantity < quantity) {
            return false;
        }

        int remainingQuantity = currentQuantity - quantity;

        if (remainingQuantity == 0) {
            holdings.remove(symbol);
        } else {
            holdings.put(symbol, remainingQuantity);
        }

        return true;
    }

    // Get number of shares
    public int getQuantity(String symbol) {

        return holdings.getOrDefault(symbol, 0);
    }

    // Display portfolio
    public void displayPortfolio() {

        System.out.println("\n===== MY PORTFOLIO =====");

        if (holdings.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }

        for (String symbol : holdings.keySet()) {

            int quantity = holdings.get(symbol);

            System.out.println(
                    symbol + " → " +
                    quantity + " shares"
            );
        }
    }
}