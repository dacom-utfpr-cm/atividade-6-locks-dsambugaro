package EX3;
/*
 *
 * @author Danilo Sambugaro 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Consumer implements Runnable {

    private Random r = new Random();
    private SharedFifoQueue circularMonitorBuffer;

    public Consumer(SharedFifoQueue circularMonitorBuffer) {
        this.circularMonitorBuffer = circularMonitorBuffer;
    }


    @Override
    public void run() {
        while (true) {

            try {

                // Consome um elemento do buffer
                Integer pop = circularMonitorBuffer.pop();
                System.out.println("[ " + Thread.currentThread().getName() + " ] Consuming " + pop);

                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
