package movieticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Theatre theatre = new Theatre();

        Booking booking = new Booking(theatre);

        Movie movie = new Movie("Leo", "Tamil");

        DiscountCoupon discountCoupon = new DiscountCoupon();

        MovieRating movieRating = new MovieRating();

        System.out.println("================================");
        System.out.println("    MOVIE TICKET BOOKING SYSTEM");
        System.out.println("================================");

        System.out.println();

        movie.displayMovie();

        // Show available seats
        theatre.displaySeats();

        // Booking date
        System.out.println();
        System.out.print("Enter booking date (yyyy-MM-dd): ");

        String dateInput = scanner.nextLine();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate bookingDate =
                LocalDate.parse(dateInput, formatter);

        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Day: " + bookingDate.getDayOfWeek());

        // Book ticket
        System.out.println();
        System.out.print("Enter seat number to book (Example: A3): ");

        String bookSeat = scanner.nextLine();

        Ticket ticket = booking.bookTicket(bookSeat, bookingDate);

        if (ticket != null) {

            ticket.displayTicket();

            // Apply coupon
            System.out.println();
            System.out.print(
                    "Enter coupon code (MOVIE10 / MOVIE20 / NO): ");

            String couponCode = scanner.nextLine();

            double originalPrice = ticket.getTicketPrice();

            double discount =
                    discountCoupon.applyDiscount(
                            couponCode,
                            originalPrice
                    );

            double finalPrice = originalPrice - discount;

            System.out.println();
            System.out.println("========== BILL ==========");
            System.out.println("Original Price : ₹" + originalPrice);
            System.out.println("Discount       : ₹" + discount);
            System.out.println("Final Price    : ₹" + finalPrice);
            System.out.println("==========================");
        }

        // Show seats after booking
        theatre.displaySeats();

        // Cancel ticket
        System.out.println();
        System.out.print("Enter seat number to cancel: ");

        String cancelSeat = scanner.nextLine();

        booking.cancelTicket(cancelSeat);

        // Show seats after cancellation
        theatre.displaySeats();

        // Movie rating
        System.out.println();
        System.out.print("Give movie rating (1 - 5): ");

        int rating = scanner.nextInt();

        boolean validRating = movieRating.setRating(rating);

        if (validRating) {

            movieRating.displayRating();

        } else {

            System.out.println();
            System.out.println("Invalid rating!");
            System.out.println("Please give a rating between 1 and 5.");
        }

        scanner.close();
    }
}