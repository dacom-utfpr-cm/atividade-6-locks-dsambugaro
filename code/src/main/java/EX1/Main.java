package EX1;
/*
 * Exercicio 1
 * Faça um programa usando Lock para simular a atualização de um contador que é acessado por múltiplas threads.
 * O contador pode diminuir e aumentar.
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX1
 *
 */

public class Main {

    public static void main(String[] args) {
        LockCounter counter = new LockCounter();
        WorkerIncrement workerIncrement = new WorkerIncrement(counter);
        WorkerDecrement workerDecrement = new WorkerDecrement(counter);

        for (int i = 0; i < 5; i++) {
            Thread increment = new Thread(workerIncrement, "Increment " + i);
            Thread decrement = new Thread(workerDecrement, "Decrement " + i);
            increment.start();
            decrement.start();
        }

    }

}
