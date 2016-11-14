/**
 * B.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class B implements Runnable {

    public void run() {
        while (true) {
            System.out.println("B");

            // A hint to the scheduler that the current thread is willing to yield its current use of a processor.
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Runnable r = new B();
        Thread t = new Thread(r);
        t.start();
    }

}