/**
 * Driver.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Driver {
    public static void main(String[] args) {
        Thread t = new A();
        Runnable r = new B();
        Thread b = new Thread(r);
        t.start();
        b.start();
    }
}