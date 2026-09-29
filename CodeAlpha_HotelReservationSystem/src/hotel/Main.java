package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // =========================
        // CREATE HOTEL
        // =========================

        Hotel hotel =
                new Hotel("Grand Palace Hotel");

        // =========================
        // ADD ROOMS
        // =========================

        hotel.addRoom(
                new Room(101, "Standard", 2000)
        );

        hotel.addRoom(
                new Room(102, "Standard", 2000)
        );

        hotel.addRoom(
                new Room(201, "Deluxe", 3500)
        );

        hotel.addRoom(
                new Room(202, "Deluxe", 3500)
        );

        hotel.addRoom(
                new Room(301, "Suite", 6000)
        );

        hotel.addRoom(
                new Room(302, "Suite", 6000)
        );

        // =========================
        // CREATE GUEST
        // =========================

        System.out.println(
                "========================================"
        );

        System.out.println(
                "       WELCOME TO GRAND PALACE HOTEL"
        );

        System.out.println(
                "========================================"
        );

        System.out.print(
                "Enter Guest ID: "
        );

        int guestId = scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "Enter Guest Name: "
        );

        String guestName = scanner.nextLine();

        System.out.print(
                "Enter Phone Number: "
        );

        String phone = scanner.nextLine();

        System.out.print(
                "Enter Email: "
        );

        String email = scanner.nextLine();

        Guest guest =
                new Guest(
                        guestId,
                        guestName,
                        phone,
                        email
                );

        int choice;

        do {

            // =========================
            // MAIN MENU
            // =========================

            System.out.println(
                    "\n========================================"
            );

            System.out.println(
                    "       HOTEL RESERVATION SYSTEM"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Search Available Rooms"
            );

            System.out.println(
                    "2. Display All Rooms"
            );

            System.out.println(
                    "3. Make Reservation"
            );

            System.out.println(
                    "4. Make Payment"
            );

            System.out.println(
                    "5. View Booking Details"
            );

            System.out.println(
                    "6. Cancel Reservation"
            );

            System.out.println(
                    "7. View All Bookings"
            );

            System.out.println(
                    "8. View Guest Details"
            );

            System.out.println(
                    "9. Exit"
            );

            System.out.println(
                    "========================================"
            );

            System.out.print(
                    "Enter your choice: "
            );

            choice = scanner.nextInt();

            scanner.nextLine();

            // =========================
            // MENU OPTIONS
            // =========================

            switch (choice) {

                // -------------------------
                // SEARCH ROOMS
                // -------------------------

                case 1:

                    System.out.println(
                            "\nSelect Room Category:"
                    );

                    System.out.println(
                            "1. Standard"
                    );

                    System.out.println(
                            "2. Deluxe"
                    );

                    System.out.println(
                            "3. Suite"
                    );

                    System.out.print(
                            "Enter category: "
                    );

                    int categoryChoice =
                            scanner.nextInt();

                    scanner.nextLine();

                    String category;

                    if (categoryChoice == 1) {

                        category = "Standard";

                    } else if (categoryChoice == 2) {

                        category = "Deluxe";

                    } else if (categoryChoice == 3) {

                        category = "Suite";

                    } else {

                        System.out.println(
                                "Invalid category."
                        );

                        break;
                    }

                    hotel.searchRooms(category);

                    break;

                // -------------------------
                // DISPLAY ALL ROOMS
                // -------------------------

                case 2:

                    hotel.displayAllRooms();

                    break;

                // -------------------------
                // MAKE RESERVATION
                // -------------------------

                case 3:

                    System.out.println(
                            "\n===== MAKE RESERVATION ====="
                    );

                    hotel.displayAllRooms();

                    System.out.print(
                            "\nEnter Room Number: "
                    );

                    int roomNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Check-in Date " +
                            "(yyyy-MM-dd): "
                    );

                    String checkInInput =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Check-out Date " +
                            "(yyyy-MM-dd): "
                    );

                    String checkOutInput =
                            scanner.nextLine();

                    try {

                        LocalDate checkInDate =
                                LocalDate.parse(
                                        checkInInput,
                                        formatter
                                );

                        LocalDate checkOutDate =
                                LocalDate.parse(
                                        checkOutInput,
                                        formatter
                                );

                        Reservation reservation =
                                hotel.makeReservation(
                                        guest,
                                        roomNumber,
                                        checkInDate,
                                        checkOutDate
                                );

                        if (reservation != null) {

                            System.out.println(
                                    "\n===== RESERVATION CREATED ====="
                            );

                            reservation
                                    .displayReservation();
                        }

                    } catch (Exception e) {

                        System.out.println(
                                "Invalid date format."
                        );

                        System.out.println(
                                "Please use yyyy-MM-dd."
                        );
                    }

                    break;

                // -------------------------
                // MAKE PAYMENT
                // -------------------------

                case 4:

                    System.out.println(
                            "\n===== MAKE PAYMENT ====="
                    );

                    System.out.print(
                            "Enter Reservation ID: "
                    );

                    int paymentReservationId =
                            scanner.nextInt();

                    scanner.nextLine();

                    Reservation paymentReservation =
                            hotel.findReservation(
                                    paymentReservationId
                            );

                    if (paymentReservation == null) {

                        System.out.println(
                                "Reservation not found."
                        );

                        break;
                    }

                    System.out.println(
                            "\nSelect Payment Method:"
                    );

                    System.out.println(
                            "1. UPI"
                    );

                    System.out.println(
                            "2. Credit/Debit Card"
                    );

                    System.out.println(
                            "3. Cash"
                    );

                    System.out.print(
                            "Enter choice: "
                    );

                    int paymentChoice =
                            scanner.nextInt();

                    scanner.nextLine();

                    String paymentMethod;

                    if (paymentChoice == 1) {

                        paymentMethod = "UPI";

                    } else if (paymentChoice == 2) {

                        paymentMethod =
                                "Credit/Debit Card";

                    } else if (paymentChoice == 3) {

                        paymentMethod = "Cash";

                    } else {

                        System.out.println(
                                "Invalid payment method."
                        );

                        break;
                    }

                    Payment payment =
                            hotel.makePayment(
                                    paymentReservation,
                                    paymentMethod
                            );

                    if (payment != null) {

                        payment.displayPayment();
                    }

                    break;

                // -------------------------
                // VIEW BOOKING
                // -------------------------

                case 5:

                    System.out.println(
                            "\n===== VIEW BOOKING ====="
                    );

                    System.out.print(
                            "Enter Reservation ID: "
                    );

                    int viewReservationId =
                            scanner.nextInt();

                    scanner.nextLine();

                    hotel.viewBooking(
                            viewReservationId
                    );

                    break;

                // -------------------------
                // CANCEL RESERVATION
                // -------------------------

                case 6:

                    System.out.println(
                            "\n===== CANCEL RESERVATION ====="
                    );

                    System.out.print(
                            "Enter Reservation ID: "
                    );

                    int cancelReservationId =
                            scanner.nextInt();

                    scanner.nextLine();

                    hotel.cancelReservation(
                            cancelReservationId
                    );

                    break;

                // -------------------------
                // VIEW ALL BOOKINGS
                // -------------------------

                case 7:

                    hotel.displayAllBookings();

                    break;

                // -------------------------
                // VIEW GUEST DETAILS
                // -------------------------

                case 8:

                    guest.displayGuest();

                    break;

                // -------------------------
                // EXIT
                // -------------------------

                case 9:

                    System.out.println(
                            "\nThank you for using "
                            + "Grand Palace Hotel!"
                    );

                    break;

                // -------------------------
                // INVALID CHOICE
                // -------------------------

                default:

                    System.out.println(
                            "Invalid choice. "
                            + "Please try again."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }
}