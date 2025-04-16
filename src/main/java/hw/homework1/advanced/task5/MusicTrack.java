package hw.homework1.advanced.task5;

public class MusicTrack {
    private String title;
    private String singer;
    private String genre;

    public MusicTrack(String title, String singer, String genre) {
        this.title = title;
        this.singer = singer;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "MusicTrack{" +
                "title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
