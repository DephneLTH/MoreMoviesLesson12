package sg.edu.rp.c346.id22035660.song;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movies(int id, String title, String genre, int year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nGenre: " + genre + "\nYear: " + year + "\nRating: " + rating;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
