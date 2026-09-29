package stocktrading;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create user
        User user = new User(
                101,
                "Sayan",
                10000
        );

        // Create trading platform
        TradingPlatform platform =
                new TradingPlatform();

        // Create stocks
        Stock apple = new Stock(
                "AAPL",
                "Apple Inc.",
                225.50
        );

        Stock microsoft = new Stock(
                "MSFT",
                "Microsoft",
                510.30
        );

        Stock tesla = new Stock(
                "TSLA",
                "Tesla Inc.",
                340.15
        );

        Stock google = new Stock(
                "GOOG",
                "Alphabet Inc.",
                198.20
        );

        // Add stocks to market
        platform.addStock(apple);
        platform.addStock(microsoft);
        platform.addStock(tesla);
        platform.addStock(google);

        int choice;

        do {

            System.out.println(
                    "\n================================"
            );

            System.out.println(
                    "     STOCK TRADING PLATFORM"
            );

            System.out.println(
                    "================================"
            );

            System.out.println(
                    "1. Display Market"
            );

            System.out.println(
                    "2. Buy Stock"
            );

            System.out.println(
                    "3. Sell Stock"
            );

            System.out.println(
                    "4. View Portfolio"
            );

            System.out.println(
                    "5. Transaction History"
            );

            System.out.println(
                    "6. View User Details"
            );

            System.out.println(
                    "7. Add Money"
            );

            System.out.println(
                    "8. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    platform.displayMarket();

                    break;

                case 2:

                    System.out.print(
                            "Enter stock symbol: "
                    );

                    String buySymbol =
                            scanner.next();

                    System.out.print(
                            "Enter quantity: "
                    );

                    int buyQuantity =
                            scanner.nextInt();

                    platform.buyStock(
                            user,
                            buySymbol,
                            buyQuantity
                    );

                    break;

                case 3:

                    System.out.print(
                            "Enter stock symbol: "
                    );

                    String sellSymbol =
                            scanner.next();

                    System.out.print(
                            "Enter quantity: "
                    );

                    int sellQuantity =
                            scanner.nextInt();

                    platform.sellStock(
                            user,
                            sellSymbol,
                            sellQuantity
                    );

                    break;

                case 4:

                    user.getPortfolio()
                            .displayPortfolio();

                    break;

                case 5:

                    platform.displayTransactions();

                    break;

                case 6:

                    user.displayUser();

                    break;

                case 7:

                    System.out.print(
                            "Enter amount to add: ₹"
                    );

                    double amount =
                            scanner.nextDouble();

                    user.addMoney(amount);

                    System.out.println(
                            "Money added successfully."
                    );

                    System.out.println(
                            "New Balance: ₹" +
                            user.getBalance()
                    );

                    break;

                case 8:

                    System.out.println(
                            "Thank you for using " +
                            "Stock Trading Platform!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Try again."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}