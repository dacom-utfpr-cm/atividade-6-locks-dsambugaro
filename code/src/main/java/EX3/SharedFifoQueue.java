package EX2;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX2
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {

    private Integer buffer[];
    private int qtElements;
    private int start;
    private int end;
    private Lock l = new ReentrantLock();
    private Condition isEmptyCondition = l.newCondition();
    private Condition isFullCondition = l.newCondition();


    SharedFifoQueue(int bufferSize) {
        buffer = new Integer[bufferSize];
    }

    private boolean isEmpty() {
        // Retorna verdadeiro caso o buffer esteja vazio ou falso caso contrário
        if (qtElements == 0) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        // Retorna verdadeiro caso o buffer esteja cheio ou falso caso contrário
        if (qtElements == buffer.length) {
            return true;
        }
        return false;
    }

    public void put(int n) throws InterruptedException {
        l.lock();
        while (this.isFull()){
            isFullCondition.await();
        }

        // Insere um elemento no buffer e move o ponteiro de inicio
        buffer[start] = n;
        qtElements++;
        start = ++start % buffer.length;

        if (this.isFull()) {
            // se estiver cheio, libera o consumidor
            isEmptyCondition.signal();
        }

        l.unlock();
    }

    public Integer pop() throws InterruptedException {

        l.lock();
        while (this.isEmpty()) {
            isEmptyCondition.await();
        }

        // Consume um elemento do buffer, movendo o ponteiro de fim
        qtElements--;
        int element = buffer[end];
        end = ++end % buffer.length;

        if (this.isEmpty()) {
            // Se estiver vazio, libera o produtor
            isFullCondition.signal();
        }

        l.unlock();

        return element;
    }

}
