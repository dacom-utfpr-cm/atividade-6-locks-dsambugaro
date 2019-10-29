package EX1;
/*
 *
 * @author Danilo Sambugaro created on 10/09/2019 inside the package - ProducerConsumer
 *
 */

import java.util.Random;

public class Producer implements Runnable {

    private CircularMonitorBuffer circularMonitorBuffer;

    public Producer(CircularMonitorBuffer circularMonitorBuffer) {
        this.circularMonitorBuffer = circularMonitorBuffer;
    }

    @Override
    public void run() {
        while (true) {

            try {
                // Produz um número aleatório e o coloca no buffer
                Random r = new Random();
                circularMonitorBuffer.put(r.nextInt());
                System.out.println("[ " + Thread.currentThread().getName() + " ] Producing...");

                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
