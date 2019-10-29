package EX2;
/*
 * Exercicio 2
 * Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila está vazia ou cheia.
 * Teste usando threads produtoras e consumidoras.
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Instancia o buffer circular e as classes produtor e consumidor
        SharedFifoQueue circularMonitorBuffer = new SharedFifoQueue(50);
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
