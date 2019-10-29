package EX3;
/*
 *
 * @author Danilo Sambugaro 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Reader implements Runnable {

    private Random r = new Random();
    private ArrayListThreadSafe<Integer> array;

    public Reader(ArrayListThreadSafe<Integer> array) {
        this.array = array;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("[ " + Thread.currentThread().getName() + " ] Reading... " + array.get(array.size()-1));
                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
