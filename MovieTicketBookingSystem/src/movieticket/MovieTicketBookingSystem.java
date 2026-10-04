package movieticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create objects
        Theatre theatre = new Theatre();

        Booking booking = new Booking(theatre);

        Movie movie = new Movie("Leo", "Tamil");

        DiscountCoupon discountCoupon = new DiscountCoupon();

        MovieRating movieRating = new MovieRating();

        // Display project heading
        System.out.println("==========================================");
        System.out.println("     MOVIE TICKET BOOKING SYSTEM");
        System.out.println("==========================================");

        System.out.println();

        // Display movie
        movie.displayMovie();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========== MENU ==========");
            System.out.println("1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Apply Discount Coupon");
            System.out.println("5. Movie Rating");
            System.out.println("6. Exit");
            System.out.println("==========================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    // Show available seats
                    theatre.displaySeats();

                    break;

                case 2:

                    // Book ticket
                    System.out.println();

                    System.out.print(
                            "Enter booking date (yyyy-MM-dd): ");

                    String dateInput = scanner.nextLine();

                    DateTimeFormatter formatter =
                            DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    LocalDate bookingDate =
                            LocalDate.parse(dateInput, formatter);

                    System.out.println(
                            "Booking Day: "
                            + bookingDate.getDayOfWeek());

                    System.out.println();

                    System.out.print(
                            "Enter seat number to book (Example: A3): ");

                    String bookSeat = scanner.nextLine();

                    Ticket ticket =
                            booking.bookTicket(
                                    bookSeat,
                                    bookingDate);

                    if (ticket != null) {

                        ticket.displayTicket();
                    }

                    break;

                case 3:

                    // Cancel ticket
                    System.out.println();

                    System.out.print(
                            "Enter seat number to cancel: ");

                    String cancelSeat = scanner.nextLine();

                    booking.cancelTicket(cancelSeat);

                    break;

                case 4:

                    // Discount coupon
                    System.out.println();

                    System.out.print(
                            "Enter original ticket price: ₹");

                    double price = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.print(
                            "Enter coupon code (MOVIE10 / MOVIE20 / NO): ");

                    String couponCode = scanner.nextLine();

                    double discount =
                            discountCoupon.applyDiscount(
                                    couponCode,
                                    price);

                    double finalPrice =
                            price - discount;

                    System.out.println();

                    System.out.println("========== BILL ==========");
                    System.out.println(
                            "Original Price : ₹" + price);

                    System.out.println(
                            "Discount       : ₹" + discount);

                    System.out.println(
                            "Final Price    : ₹" + finalPrice);

                    System.out.println("==========================");

                    break;

                case 5:

                    // Movie rating
                    System.out.println();

                    System.out.print(
                            "Give movie rating (1 - 5): ");

                    int rating = scanner.nextInt();

                    scanner.nextLine();

                    boolean validRating =
                            movieRating.setRating(rating);

                    if (validRating) {

                        movieRating.displayRating();

                    } else {

                        System.out.println();
                        System.out.println("Invalid rating!");
                        System.out.println(
                                "Please give a rating between 1 and 5.");
                    }

                    break;

                case 6:

                    // Exit
                    running = false;

                    System.out.println();
                    System.out.println(
                            "Thank you for using Movie Ticket Booking System!");

                    break;

                default:

                    System.out.println();
                    System.out.println("Invalid choice!");
                    System.out.println(
                            "Please select a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}