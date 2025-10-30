import java.util.Scanner;

public class MusicManagerMain {

    private Playlist playlist = new Playlist();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        preloadPlaylist();

        int option = 0;
        while (option != 8) {
            displayMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    playlist.nextSong();
                    break;
                case 2:
                    playlist.previousSong();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    playlist.playCurrentSong();
                    break;
                case 5:
                    addSongMenu();
                    break;
                case 6:
                    removeSongMenu();
                    break;
                case 7:
                    playlist.listSongs();
                    break;
                case 8:
                    System.out.println("Thank you for using the Music Manager!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Welcome to your Music Manager! ---");
        playlist.playCurrentSong();
        System.out.println("----------------------------------------");
        System.out.println("1. Next song");
        System.out.println("2. Previous song");
        System.out.println("3. Sort playlist");
        System.out.println("4. Play song (show current)");
        System.out.println("5. Add song");
        System.out.println("6. Remove song");
        System.out.println("7. List songs");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void sortMenu() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Artist");
        System.out.print("Choice: ");
        String criterion = scanner.nextLine();
        if (criterion.equals("1")) {
            playlist.sort("title");
        } else if (criterion.equals("2")) {
            playlist.sort("artist");
        } else {
            System.out.println("Invalid criterion.");
        }
    }

    private void addSongMenu() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Album: ");
        String album = scanner.nextLine();
        System.out.print("Duration (in seconds): ");
        int duration = Integer.parseInt(scanner.nextLine());

        Song newSong = new Song(title, artist, album, duration);

        System.out.println("Add to which location?");
        System.out.println("1. Start");
        System.out.println("2. End");
        System.out.println("3. Specific position");
        System.out.print("Choice: ");
        String location = scanner.nextLine();

        if (location.equals("1")) {
            playlist.addFirst(newSong);
        } else if (location.equals("2")) {
            playlist.addLast(newSong);
        } else if (location.equals("3")) {
            System.out.print("Enter position (index): ");
            int pos = Integer.parseInt(scanner.nextLine());
            playlist.addAtPosition(newSong, pos);
        } else {
            System.out.println("Invalid option, adding to end by default.");
            playlist.addLast(newSong);
        }
    }

    private void removeSongMenu() {
        System.out.print("Enter the exact TITLE of the song to remove: ");
        String title = scanner.nextLine();
        playlist.removeByTitle(title);
    }

    private void preloadPlaylist() {
        System.out.println("Loading initial playlist...");
        playlist.addLast(new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 355));
        playlist.addLast(new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482));
        playlist.addLast(new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        playlist.addLast(new Song("Hotel California", "Eagles", "Hotel California", 391));
    }

    public static void main(String[] args) {
        MusicManagerMain player = new MusicManagerMain();
        player.run();
    }
}