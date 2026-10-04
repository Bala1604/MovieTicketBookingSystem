package movieticket;

public class MovieRating {

    private int rating;

    // Set movie rating
    public boolean setRating(int rating) {

        if (rating >= 1 && rating <= 5) {

            this.rating = rating;

            return true;

        } else {

            return false;
        }
    }

    // Get rating
    public int getRating() {

        return rating;
    }

    // Display rating
    public void displayRating() {

        System.out.println();
        System.out.println("========== MOVIE RATING ==========");

        System.out.println("Rating: " + rating + " / 5");

        System.out.print("Stars: ");

        for (int i = 1; i <= rating; i++) {

            System.out.print("★");
        }

        System.out.println();
        System.out.println("==================================");
    }
}