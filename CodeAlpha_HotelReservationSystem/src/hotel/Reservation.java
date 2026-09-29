package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private int reservationId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;
    private String status;

    public Reservation(
            int reservationId,
            Guest guest,
            Room room,
            LocalDate checkInDate,
            LocalDate checkOutDate) {

        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

        // Calculate number of nights
        long nights = ChronoUnit.DAYS.between(
                checkInDate,
                checkOutDate
        );

        // Calculate total amount
        this.totalAmount =
                nights * room.getPricePerNight();

        this.status = "CONFIRMED";
    }

    public int getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void cancelReservation() {
        status = "CANCELLED";
    }

    public void displayReservation() {

        long nights = ChronoUnit.DAYS.between(
                checkInDate,
                checkOutDate
        );

        System.out.println(
                "\n===== BOOKING DETAILS ====="
        );

        System.out.println(
                "Reservation ID: " +
                reservationId
        );

        System.out.println(
                "Guest Name: " +
                guest.getName()
        );

        System.out.println(
                "Room Number: " +
                room.getRoomNumber()
        );

        System.out.println(
                "Room Category: " +
                room.getCategory()
        );

        System.out.println(
                "Check-in: " +
                checkInDate
        );

        System.out.println(
                "Check-out: " +
                checkOutDate
        );

        System.out.println(
                "Number of Nights: " +
                nights
        );

        System.out.println(
                "Price per Night: ₹" +
                room.getPricePerNight()
        );

        System.out.println(
                "Total Amount: ₹" +
                totalAmount
        );

        System.out.println(
                "Status: " +
                status
        );
    }
}