/**
 * Divider.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Divider implements Runnable {

    // Shared by all threads
    int counter;

    // Each thread should be given a start and end integer when constructed

    // Each thread should check every number from start to end and should increment counter every time it finds a number divisible by 7

    // Create and start 3 threads to find how many numbers between 1 and 3000 are divisible by 7:
    // 1. Thread t1 should check from 1 to 1000.
    // 2. Thread t2 should check from 1001 to 2000.
    // 3. Thread t3 should check from 2001 to 3000.

    // Use the join() method to be sure that all three threads have finished running.
    // Print value of counter
    // Catch InterruptedException("Big problem")

    @Override
    public void run() {

    }
}