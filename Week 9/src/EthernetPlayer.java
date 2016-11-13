import java.util.ArrayList;

/**
 * Class EthernetPlayer
 *
 *
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 15, 2016
 *
 */

public class EthernetPlayer extends MusicPlayer {

    private int deviceID;
    private int connStatus;

    static final int CONNECTED = 1;
    static final int NOT_CONNECTED = 0;

    private ArrayList<String> downloadList = new ArrayList<String>();

    public EthernetPlayer(int id) {
        super(); // why do we need this?
        deviceID = id;
        connStatus = NOT_CONNECTED;

        downloadList.add("Dark Horse");
        downloadList.add("Royals");
        downloadList.add("Counting Stars");
        downloadList.add("Let Her Go");
        downloadList.add("The Fox");
    }

    /**
     *  @override turnOn and connect
     *
     */
    @Override
    public void turnOn() {
        connStatus = CONNECTED;
        super.turnOn();
    }

    /**
     *  @override turnOff and disconnect
     *
     */
    @Override
    public void turnOff() {
        connStatus = NOT_CONNECTED;
        super.turnOff();
    }


    /**
     *  addTrackToPlaylist: Adds mentioned track to the end of playlist array
     *  print appropriate messages to stdout
     *
     */
    public void addToPlaylist(String trackName) {
        playlist.add(trackName);
        System.out.println("Added " + trackName + " to playlist");
    }

    /**
     *  deleteFromPlaylist: deletes track of give name from the playlist
     *  print appropriate messages to stdout
     *
     */
    public void deleteFromPlaylist(String trackName) {
        if (playlist.contains(trackName)) {
            playlist.remove(trackName);
            System.out.println("Removed " + trackName + " from playlist");
        }
    }

    /**
     *  download: Downloads mentioned song from the given Download list and adds to playlist
     *  print appropriate messages to stdout
     *
     */
    public void download(String trackName) {
        if (downloadList.contains(trackName)) {
            playlist.add(trackName);
            System.out.println("Downloaded " + trackName);
        } else {
            System.out.println("Track " + trackName + " not available for download");
        }
    }

}
