package EX3;
/*
 * Exercicio 3
 * Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
 * Teste usando threads que realizam leitura e escrita para essa estrutura.
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayListThreadSafe<Integer> integerArrayListThreadSafe = new ArrayListThreadSafe<>();

        Writer writer = new Writer(integerArrayListThreadSafe);
        Reader reader = new Reader(integerArrayListThreadSafe);

        Random r = new Random();
        int qtReadersWriters = r.nextInt((5 - 2) + 1) + 2; // Gera um número aleatório entre 2 e 5

        // Cria qtReadersWriters threads de produtores e consumidores e as inicia
        for (int i = 0; i < qtReadersWriters; i++) {
            Thread writerThread = new Thread(writer, "Writer " + i);
            Thread readerThread = new Thread(reader, "Reader " + i);

            writerThread.start();
            readerThread.start();
        }

    }

}
