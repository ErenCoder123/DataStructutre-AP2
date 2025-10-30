public class SongNode {
    Song song;
    SongNode next;     //
    SongNode previous; //

    public SongNode(Song song) {
        this.song = song;
        this.next = null;
        this.previous = null;
    }
}