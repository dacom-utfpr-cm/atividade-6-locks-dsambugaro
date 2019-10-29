package EX1;
/*
 *
 * @author Danilo Sambugaro created on 10/09/2019 inside the package - ProducerConsumer
 *
 */

import java.util.Random;

public class Consumer implements Runnable {

    private CircularMonitorBuffer circularMonitorBuffer;

    public Consumer(CircularMonitorBuffer circularMonitorBuffer) {
        this.circularMonitorBuffer = circularMonitorBuffer;
    }


    @Override
    public void run() {
        while (true) {

            try {

                // Consome um elemento do buffer
                Integer pop = circularMonitorBuffer.pop();
                System.out.println("[ " + Thread.currentThread().getName() + " ] Consuming " + pop);

                Random r = new Random();
                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
