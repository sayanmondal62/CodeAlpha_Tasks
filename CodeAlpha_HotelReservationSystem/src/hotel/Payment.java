package hotel;

import java.time.LocalDateTime;

public class Payment {

    private int paymentId;
    private int reservationId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    public Payment(
            int paymentId,
            int reservationId,
            double amount,
            String paymentMethod) {

        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

        // Simulate successful payment
        this.paymentStatus = "SUCCESSFUL";

        this.paymentDate = LocalDateTime.now();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void displayPayment() {

        System.out.println("\n===== PAYMENT DETAILS =====");

        System.out.println(
                "Payment ID: " + paymentId
        );

        System.out.println(
                "Reservation ID: " + reservationId
        );

        System.out.println(
                "Amount: ₹" + amount
        );

        System.out.println(
                "Payment Method: " +
                paymentMethod
        );

        System.out.println(
                "Payment Status: " +
                paymentStatus
        );

        System.out.println(
                "Payment Date: " +
                paymentDate
        );
    }
}