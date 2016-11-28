import java.util.concurrent.atomic.AtomicInteger;

/**
 * Divider.java
 *
 * Calculates total number of values between 1 and 3000 that are divisible by 7
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Divider implements Runnable {

    public static AtomicInteger counter = new AtomicInteger(); // Shared by all threads

    int start;
    int end;

    public Divider (int start, int end) {

        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
            for (int i = start; i < end; i++) {
                if (i % 7 == 0) { // Check if it is divisible by 7
                    counter.incrementAndGet();
                }
            }
    }

    public static void main(String[] args) throws InterruptedException {

        // Each thread should be given a start and end integer when constructed
        Thread t1 = new Thread (new Divider(1, 1000)); // Check from 1 to 1000
        Thread t2 = new Thread (new Divider(1001, 2000)); // Check from 1001 to 2000
        Thread t3 = new Thread (new Divider(2001, 3000)); // Check from 2001 to 3000

        // Each thread should check every number from start to end and should
        // increment counter every time it finds a number divisible by 7
        t1.start();
        t2.start();
        t3.start();

        // Use the join() method to be sure that all three threads have finished running.
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Big problem");
        }

        // Print value of counter
        System.out.println(counter);

    }

}