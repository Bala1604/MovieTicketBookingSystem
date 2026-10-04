package movieticket;

public class Ticket {

    private String seatNumber;
    private double ticketPrice;

    public Ticket(String seatNumber, double ticketPrice) {

        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
    }

    public String getSeatNumber() {

        return seatNumber;
    }

    public double getTicketPrice() {

        return ticketPrice;
    }

    public void displayTicket() {

        System.out.println();
        System.out.println("========== TICKET ==========");
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Ticket Price: ₹" + ticketPrice);
        System.out.println("============================");
    }
}