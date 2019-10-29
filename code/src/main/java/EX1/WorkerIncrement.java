package EX1;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX1
 *
 */

import java.util.Random;

public class WorkerIncrement implements Runnable {

    private Random r = new Random();
    private LockCounter counter;

    WorkerIncrement(LockCounter counter){
        this.counter = counter;
    }


    @Override
    public void run() {
        while (true) {

            try {

                counter.increment();
                System.out.println("[ " + Thread.currentThread().getName() + " ] Increment value to " + counter.getValue());

                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
