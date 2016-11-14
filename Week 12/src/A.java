/**
 * A.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class A extends Thread {

    public void run() {
        while (true) {
            System.out.println("A");

            // A hint to the scheduler that the current thread is willing to yield its current use of a processor.
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Thread t = new A();
        t.start();
    }

}