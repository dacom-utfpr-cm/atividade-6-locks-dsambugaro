package EX1;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX1
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private Lock l = new ReentrantLock();
    private int counter;

    public void increment(){
        l.lock();
        counter++;
        l.unlock();
    }

    public void decrement(){
        l.lock();
        counter--;
        l.unlock();
    }

    public int getValue(){
        int value = counter;
        return value;
    }
}
