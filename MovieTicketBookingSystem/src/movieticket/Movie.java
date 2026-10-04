package movieticket;

public class Movie {

    private String movieName;
    private String language;

    public Movie(String movieName, String language) {

        this.movieName = movieName;
        this.language = language;
    }

    public void displayMovie() {

        System.out.println("Movie    : " + movieName);
        System.out.println("Language : " + language);
    }
}