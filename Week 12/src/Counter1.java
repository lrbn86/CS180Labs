/**
 * Counter1.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Counter1 implements Counter {

    private int value = 0;

    public synchronized void inc() {
        value = value + 1;
    }

    public synchronized void dec() {
        value = value - 1;
    }

    public synchronized int get() {
        return value;
    }

}