import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

        public class videoStore {

            private static final int MAX_VIDEOS = 5;
            private VideoTape[] videoTapes = new VideoTape[MAX_VIDEOS];
            private int numVideos = 0; // So here we are creating new variables in our
            private String FILENAME = "videoTapes.txt"; // database

            private void saveTapesToTextFile() {
                try {
                    FileWriter theFileID = new FileWriter(FILENAME, true);
                    PrintWriter outFile = new PrintWriter(theFileID);
                    for (int x = 0; x < numVideos; x++) {
                        outFile.println("Title: " + videoTapes[x].getTitle());
                        outFile.println("Length: " + videoTapes[x].getLength() + " mins");
                        outFile.println("Rented?: " + videoTapes[x].isLent());
                        outFile.println(" ");
                    }
                    outFile.close();

                } catch (IOException io) {
                    IOQ.output("Some error " + io.getMessage());
                }
            }

            public static void main(String[] args) {
                new videoStore(); // Here we are creating empty VideoStore instance to
        // stop this
    }

    private videoStore() { // Here we are entering into our application
        char command;
        do {
            command = getCommand(); // going to the method, called: getCommand()
            doCommand(command);
        } while (command != 'q');
    }

    private char getCommand() { // We are taking out commands and then
        // validating them
        char ch;
        do {
            IOQ.output("");
            IOQ.output("Would you like to");
            IOQ.output(" (a) add a video tape to the collection");
            IOQ.output(" (l) list the tapEs already in the collection");
            IOQ.output(" (s) save videotapes collection to the text file");
            IOQ.output(" (q) or quit thE program");
            IOQ.output("");

            ch = IOQ.inputChar("Your choice (a/l/s/q) :");

            if (ch == 0) {
                IOQ.output("Please enter a command!");
                ch = 'n';
            } else {
                if ((ch != 'a') && (ch != 'l') && (ch != 'q') && (ch != 's')) {
                    IOQ.output("Please anter a valid command (a, l, s or q) !");
                    ch = 'n';
                }
            }
        } while (ch == 'n');
        return ch;
    }

    private void doCommand(char command) { // Here we are actually writing the
        // commands actions
        int x;
        if (command == 'a') {
            if (numVideos > MAX_VIDEOS) {
                IOQ.output("Sorry, no more videos can be stored");
            } else {
                videoTapes[numVideos] = VideoTape.getVideoDetails();
                numVideos = numVideos + 1;
            }
        } else if (command == 'l') {
            for (x = 0; x < numVideos; x++) {
                IOQ.output(x + ":");
                IOQ.output("Title: " + videoTapes[x].getTitle());
                IOQ.output("Duration: " + videoTapes[x].getLength());
                IOQ.output("Is it rented? " + videoTapes[x].isLent());
            }
        } else if (command == 'q') {
            IOQ.output("Bye then");
        } else if (command == 's') {
            saveTapesToTextFile();
        } else {
            IOQ.output("Some internal error in doCommand");
        }
    }
}