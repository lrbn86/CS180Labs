import java.util.concurrent.atomic.AtomicInteger;

/**
 * Counter2.java
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 13, 2016
 *
 */
public class Counter2 implements Counter {

    private AtomicInteger value = new AtomicInteger();

    @Override
    public void inc() {
        value.incrementAndGet();
    }

    @Override
    public void dec() {
        value.decrementAndGet();
    }

    @Override
    public int get() {return value.get();}


}