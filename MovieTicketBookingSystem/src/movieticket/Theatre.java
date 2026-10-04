package movieticket;

public class Theatre {

    private boolean[][] seats;

    public Theatre() {

        seats = new boolean[4][5];
    }

    // Display all seats
    public void displaySeats() {

        System.out.println();
        System.out.println("========== SEAT LAYOUT ==========");

        System.out.println();
        System.out.println("        1   2   3   4   5");

        for (int i = 0; i < seats.length; i++) {

            char row = (char) ('A' + i);

            System.out.print(row + "       ");

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == false) {
                    System.out.print("O   ");
                } else {
                    System.out.print("X   ");
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("O = Available");
        System.out.println("X = Booked");
    }

    // Book a seat
    public boolean bookSeat(String seatNumber) {

        seatNumber = seatNumber.toUpperCase();

        char row = seatNumber.charAt(0);
        int column = Character.getNumericValue(seatNumber.charAt(1));

        int rowIndex = row - 'A';
        int columnIndex = column - 1;

        // Check valid seat
        if (rowIndex < 0 || rowIndex >= seats.length ||
            columnIndex < 0 || columnIndex >= seats[rowIndex].length) {

            return false;
        }

        // Check whether already booked
        if (seats[rowIndex][columnIndex]) {

            return false;
        }

        // Book the seat
        seats[rowIndex][columnIndex] = true;

        return true;
    }

    // Check whether seat is booked
    public boolean isBooked(String seatNumber) {

        seatNumber = seatNumber.toUpperCase();

        char row = seatNumber.charAt(0);
        int column = Character.getNumericValue(seatNumber.charAt(1));

        int rowIndex = row - 'A';
        int columnIndex = column - 1;

        if (rowIndex < 0 || rowIndex >= seats.length ||
            columnIndex < 0 || columnIndex >= seats[rowIndex].length) {

            return false;
        }

        return seats[rowIndex][columnIndex];
    }

    // Cancel a booked seat
    public boolean cancelSeat(String seatNumber) {

        seatNumber = seatNumber.toUpperCase();

        char row = seatNumber.charAt(0);
        int column = Character.getNumericValue(seatNumber.charAt(1));

        int rowIndex = row - 'A';
        int columnIndex = column - 1;

        // Check whether seat number is valid
        if (rowIndex < 0 || rowIndex >= seats.length ||
            columnIndex < 0 || columnIndex >= seats[rowIndex].length) {

            return false;
        }

        // Check whether seat is actually booked
        if (seats[rowIndex][columnIndex] == false) {

            return false;
        }

        // Cancel the seat
        seats[rowIndex][columnIndex] = false;

        return true;
    }
}