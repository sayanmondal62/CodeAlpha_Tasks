package hotel;

public class Guest {

    private int guestId;
    private String name;
    private String phone;
    private String email;

    public Guest(
            int guestId,
            String name,
            String phone,
            String email) {

        this.guestId = guestId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void displayGuest() {

        System.out.println("\n===== GUEST DETAILS =====");

        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}