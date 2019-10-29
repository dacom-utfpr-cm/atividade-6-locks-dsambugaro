package EX2;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Producer implements Runnable {

    private Random r = new Random();
    private SharedFifoQueue circularMonitorBuffer;

    public Producer(SharedFifoQueue circularMonitorBuffer) {
        this.circularMonitorBuffer = circularMonitorBuffer;
    }

    @Override
    public void run() {
        while (true) {

            try {
                // Produz um número aleatório e o coloca no buffer
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
