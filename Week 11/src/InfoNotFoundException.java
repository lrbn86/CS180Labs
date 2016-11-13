/**
 * InfoNotFoundException.java
 *
 * An exception thrown when username is not found in file.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class InfoNotFoundException extends Exception {
    public InfoNotFoundException() {}
    public InfoNotFoundException(String msg) {
        super(msg);
    }
}