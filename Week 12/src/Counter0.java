/**
 * Counter0.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Counter0 implements Counter {

    private int value = 0;

    public void inc() {
        value = value + 1;
    }

    public void dec() {
        value = value - 1;
    }

    public int get() {
        return value;
    }

}