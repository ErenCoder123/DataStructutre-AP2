public class Song {
    String title;
    String artist;
    String album;
    int durationInSeconds;

    public Song(String title, String artist, String album, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public String toString() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("'%s' - %s (%s) [%d:%02d]", title, artist, album, minutes, seconds);
    }
}