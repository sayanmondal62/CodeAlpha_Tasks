package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {

    private String hotelName;

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private ArrayList<Payment> payments;

    private int nextReservationId = 1001;
    private int nextPaymentId = 5001;

    public Hotel(String hotelName) {

        this.hotelName = hotelName;

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        payments = new ArrayList<>();
    }

    // Add room
    public void addRoom(Room room) {

        rooms.add(room);
    }

    // Display all rooms
    public void displayAllRooms() {

        System.out.println("\n===== ALL ROOMS =====");

        if (rooms.isEmpty()) {

            System.out.println("No rooms available.");

            return;
        }

        for (Room room : rooms) {

            room.displayRoom();
        }
    }

    // Search available rooms by category
    public void searchRooms(String category) {

        System.out.println(
                "\n===== AVAILABLE " +
                category.toUpperCase() +
                " ROOMS ====="
        );

        boolean found = false;

        for (Room room : rooms) {

            if (room.getCategory()
                    .equalsIgnoreCase(category)
                    && room.isAvailable()) {

                room.displayRoom();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No available rooms found."
            );
        }
    }

    // Find room by room number
    public Room findRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                return room;
            }
        }

        return null;
    }

    // Make reservation
    public Reservation makeReservation(
            Guest guest,
            int roomNumber,
            LocalDate checkInDate,
            LocalDate checkOutDate) {

        Room room = findRoom(roomNumber);

        // Check room
        if (room == null) {

            System.out.println(
                    "Room not found."
            );

            return null;
        }

        // Check availability
        if (!room.isAvailable()) {

            System.out.println(
                    "Room is already booked."
            );

            return null;
        }

        // Check dates
        if (!checkOutDate.isAfter(checkInDate)) {

            System.out.println(
                    "Check-out date must be after "
                    + "check-in date."
            );

            return null;
        }

        // Create reservation
        Reservation reservation =
                new Reservation(
                        nextReservationId,
                        guest,
                        room,
                        checkInDate,
                        checkOutDate
                );

        // Mark room as booked
        room.setAvailable(false);

        // Add reservation
        reservations.add(reservation);

        nextReservationId++;

        System.out.println(
                "\nReservation created successfully!"
        );

        return reservation;
    }

    // Find reservation
    public Reservation findReservation(
            int reservationId) {

        for (Reservation reservation :
                reservations) {

            if (reservation.getReservationId()
                    == reservationId) {

                return reservation;
            }
        }

        return null;
    }

    // Cancel reservation
    public void cancelReservation(
            int reservationId) {

        Reservation reservation =
                findReservation(reservationId);

        if (reservation == null) {

            System.out.println(
                    "Reservation not found."
            );

            return;
        }

        if (reservation.getStatus()
                .equals("CANCELLED")) {

            System.out.println(
                    "Reservation is already cancelled."
            );

            return;
        }

        // Cancel reservation
        reservation.cancelReservation();

        // Make room available again
        reservation.getRoom()
                .setAvailable(true);

        System.out.println(
                "Reservation cancelled successfully."
        );
    }

    // Process payment
    public Payment makePayment(
            Reservation reservation,
            String paymentMethod) {

        if (reservation == null) {

            System.out.println(
                    "Invalid reservation."
            );

            return null;
        }

        if (reservation.getStatus()
                .equals("CANCELLED")) {

            System.out.println(
                    "Cannot pay for a cancelled reservation."
            );

            return null;
        }

        Payment payment =
                new Payment(
                        nextPaymentId,
                        reservation.getReservationId(),
                        reservation.getTotalAmount(),
                        paymentMethod
                );

        payments.add(payment);

        nextPaymentId++;

        System.out.println(
                "\nPayment successful!"
        );

        return payment;
    }

    // View reservation
    public void viewBooking(
            int reservationId) {

        Reservation reservation =
                findReservation(reservationId);

        if (reservation == null) {

            System.out.println(
                    "Reservation not found."
            );

            return;
        }

        reservation.displayReservation();
    }

    // Display all bookings
    public void displayAllBookings() {

        System.out.println(
                "\n===== ALL BOOKINGS ====="
        );

        if (reservations.isEmpty()) {

            System.out.println(
                    "No bookings found."
            );

            return;
        }

        for (Reservation reservation :
                reservations) {

            reservation.displayReservation();
        }
    }

    public String getHotelName() {

        return hotelName;
    }
}