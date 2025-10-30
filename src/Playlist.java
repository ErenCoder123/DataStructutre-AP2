public class Playlist {
    private SongNode head;
    private SongNode tail;
    private SongNode currentSong;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentSong = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public void addFirst(Song song) {
        SongNode newNode = new SongNode(song);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.currentSong = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.size++;
        System.out.println("Song added to the beginning: " + song);
    }

    public void addLast(Song song) {
        SongNode newNode = new SongNode(song);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.currentSong = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.size++;
        System.out.println("Song added to the end: " + song);
    }

    public void addAtPosition(Song song, int position) {
        if (position < 0 || position > this.size) {
            System.out.println("Invalid position. Valid positions: 0 to " + this.size);
            return;
        }
        if (position == 0) {
            addFirst(song);
            return;
        }
        if (position == this.size) {
            addLast(song);
            return;
        }

        SongNode previousNode = this.head;
        for (int i = 0; i < position - 1; i++) {
            previousNode = previousNode.next;
        }

        SongNode nextNode = previousNode.next;
        SongNode newNode = new SongNode(song);

        newNode.next = nextNode;
        newNode.previous = previousNode;
        previousNode.next = newNode;
        nextNode.previous = newNode;

        this.size++;
        System.out.println("Song added at position " + position + ": " + song);
    }


    public void removeByTitle(String title) {
        if (isEmpty()) {
            System.out.println("Playlist is empty, nothing to remove.");
            return;
        }

        SongNode current = this.head;
        while (current != null && !current.song.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Song not found: " + title);
            return;
        }

        removeNode(current);
        System.out.println("Song removed: " + title);
    }

    private void removeNode(SongNode nodeToRemove) {
        if (nodeToRemove == this.head) {
            this.head = nodeToRemove.next;
        }
        if (nodeToRemove == this.tail) {
            this.tail = nodeToRemove.previous;
        }

        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        }
        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        }

        if (this.currentSong == nodeToRemove) {
            if (this.currentSong.next != null) {
                this.currentSong = this.currentSong.next;
            } else {
                this.currentSong = this.currentSong.previous;
            }
        }

        this.size--;

        if (this.size == 0) {
            this.head = null;
            this.tail = null;
            this.currentSong = null;
        }
    }

    public void nextSong() {
        if (this.currentSong == null) {
            System.out.println("Playlist is empty.");
        } else if (this.currentSong.next != null) {
            this.currentSong = this.currentSong.next;
            System.out.println("Moving to next...");
            playCurrentSong();
        } else {
            System.out.println("You are at the last song of the playlist.");
        }
    }

    public void previousSong() {
        if (this.currentSong == null) {
            System.out.println("Playlist is empty.");
        } else if (this.currentSong.previous != null) {
            this.currentSong = this.currentSong.previous;
            System.out.println("Moving to previous...");
            playCurrentSong();
        } else {
            System.out.println("You are at the first song of the playlist.");
        }
    }

    public void playCurrentSong() {
        if (this.currentSong == null) {
            System.out.println("Nothing to play. The playlist is empty.");
        } else {
            System.out.println("Now playing: " + this.currentSong.song);
        }
    }

    public void listSongs() {
        if (isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        }
        System.out.println("\n--- Full Playlist (" + this.size + " songs) ---");
        SongNode current = this.head;
        int i = 0;
        while (current != null) {
            String indicator = (current == this.currentSong) ? " <== (Now Playing)" : "";
            System.out.printf("  %d. %s %s\n", i, current.song, indicator);
            current = current.next;
            i++;
        }
        System.out.println("----------------------------------------");
    }

    public void sort(String criterion) {
        if (this.size < 2) {
            System.out.println("Playlist needs at least 2 songs to be sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            SongNode current = this.head;
            while (current.next != null) {
                SongNode nextNode = current.next;
                int comparison = 0;

                if (criterion.equals("title")) {
                    comparison = current.song.title.compareToIgnoreCase(nextNode.song.title);
                } else if (criterion.equals("artist")) {
                    comparison = current.song.artist.compareToIgnoreCase(nextNode.song.artist);
                }

                if (comparison > 0) {
                    // Swap the data (Song) between the nodes
                    Song temp = current.song;
                    current.song = nextNode.song;
                    nextNode.song = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        this.currentSong = this.head;
        System.out.println("Playlist sorted by " + criterion + ".");
        listSongs();
    }
}