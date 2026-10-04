package movieticket;

import java.time.LocalDate;

public class Booking {

    private Theatre theatre;
    private WeekendPricing weekendPricing;

    public Booking(Theatre theatre) {

        this.theatre = theatre;
        this.weekendPricing = new WeekendPricing();
    }

    // Book ticket
    public Ticket bookTicket(String seatNumber, LocalDate date) {

        boolean booked = theatre.bookSeat(seatNumber);

        if (booked) {

            double price = weekendPricing.calculatePrice(date);

            Ticket ticket = new Ticket(seatNumber, price);

            System.out.println();
            System.out.println("Ticket booked successfully!");

            if (weekendPricing.isWeekend(date)) {

                System.out.println("Weekend pricing applied.");

            } else {

                System.out.println("Normal weekday pricing applied.");
            }

            return ticket;

        } else {

            System.out.println();
            System.out.println("Seat is invalid or already booked.");

            return null;
        }
    }

    // Cancel ticket
    public boolean cancelTicket(String seatNumber) {

        boolean cancelled = theatre.cancelSeat(seatNumber);

        if (cancelled) {

            System.out.println();
            System.out.println("Ticket cancelled successfully!");
            System.out.println("Cancelled Seat: " + seatNumber);

            return true;

        } else {

            System.out.println();
            System.out.println("Cannot cancel ticket.");
            System.out.println("Seat is invalid or not booked.");

            return false;
        }
    }
}