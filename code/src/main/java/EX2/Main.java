package EX1;
/*
 * Exercicio 1
 * Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.
 *
 * @author Danilo Sambugaro created on 17/09/2019 inside the package - EX1
 *
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Instancia o buffer circular e as classes produtor e consumidor
        CircularMonitorBuffer circularMonitorBuffer = new CircularMonitorBuffer(50);
        Producer producer = new Producer(circularMonitorBuffer);
        Consumer consumer = new Consumer(circularMonitorBuffer);

        Random r = new Random();
        int qtProducersConsumers = r.nextInt((5 - 2) + 1) + 2; // Gera um número aleatório entre 2 e 5

        // Cria qtProducersConsumers threads de produtores e consumidores e as inicia
        for (int i = 0; i < qtProducersConsumers; i++) {
            Thread producerThread = new Thread(producer, "ProducerThread " + i);
            Thread consumerThread = new Thread(consumer, "ConsumerThread " + i);

            producerThread.start();
            consumerThread.start();
        }

    }

}
