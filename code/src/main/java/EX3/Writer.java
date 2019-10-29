package EX3;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Writer implements Runnable {

    private Random r = new Random();
    private ArrayListThreadSafe<Integer> array;

    public Writer(ArrayListThreadSafe array) {
        this.array = array;

    }

    @Override
    public void run() {
        while (true) {

            try {
                // Produz um número aleatório e o coloca no buffer
                array.add(r.nextInt());
                System.out.println("[ " + Thread.currentThread().getName() + " ] Writing...");

                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
