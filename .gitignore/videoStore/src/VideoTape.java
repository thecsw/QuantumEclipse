
public class VideoTape {
    private String title;
    private int length;
    private boolean lent;

    public VideoTape() { //Empty constructor to give empty values
        this.title=null;
        this.length=0;
        this.lent=false;
    }

    public VideoTape(String title, int length, boolean lent) { //Constructor is taking the values out variables
        setTitle(title);
        setLength(length);
        setLent(lent);
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setLength(int length) {
        this.length=length;
    }

    public void setLent(boolean lent) {
        this.lent=lent; //we are  setting the value
    }

    public String getTitle() {
        return  this.title;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isLent() {
        return this.lent; //here we are getting the values
    }

    static public VideoTape getVideoDetails() {
        String title = IOQ.input("Enter the title of your video: ");
        int length = IOQ.inputInt("Enter the length in minutes: ");
        return new VideoTape(title, length, false); //we are inputting tapes details
    }
}