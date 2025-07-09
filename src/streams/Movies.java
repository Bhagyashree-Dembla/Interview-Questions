package streams;

public class Movies {
    private String movie;

    private int likes;

    private Genre genre;

    public Movies(String movie, int likes, Genre genre) {
        this.movie = movie;
        this.likes = likes;
        this.genre = genre;
    }

    public int getLikes() {
        return likes;
    }

    public String getMovie() {
        return movie;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie='" + movie + '\'' +
                ", likes=" + likes +
                '}';
    }
}
