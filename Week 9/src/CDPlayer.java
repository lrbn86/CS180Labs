import java.util.ArrayList;
/**
 * Class CDPlayer
 *
 *
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 28, 2016
 *
 */
public class CDPlayer extends MusicPlayer {

    private int deviceID;
    private int thisTrack;

    /**
     * Constructor for CD-Player
     */
    public CDPlayer(int id) {
        this.deviceID = id;
        thisTrack = 0;
    }

    /**
     * Over-ride Method: turnOn
     */
    @Override
    public void turnOn() {
        thisTrack = 0;
        super.turnOn();
    }

    /**
     * Over-ride Method: turnOff
     */
    @Override
    public void turnOff() {
        thisTrack = 0;
        super.turnOff();
    }

    /**
     * Method to play next track in the playlist by
     * printing it to stdout and changing current
     */
    public void nextTrack() {
        thisTrack++;
        play();
    }

    /**
     * Method to play previous track in the playlist by
     * printing it to stdout and changing current
     */
    public void previousTrack() {
        thisTrack--;
        play();
    }

    /**
     * Method to play current track
     */
    public void play() {
        // Skip to the next track or return to the previous track
        System.out.println("Playing: " + playlist.get(thisTrack));
    }

}
