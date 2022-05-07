//AUTOR 30000497 ANTÓNIO GRAÇA

import java.util.LinkedList;

public class QList extends Thread {

    LinkedList<Integer> queue = new LinkedList<>(); //Criação de LinkedList para funcionar como fila de espera
    int q_length = 1; //Variável que serve como "tamanho" para condições While
    int Value = 0; //Criação de variável que será iterada para simular a contagem das peças
    int i;

    public void produ(int iter) throws InterruptedException { //Método produtor
        while (i < iter) {
            synchronized (this) { //Bloco sincronizado
                while (queue.size() == q_length) { //Se a fila de espera tiver um valor
                    this.wait(); //Thread fica suspensa até que a condição mude
                }
                Value++; //Iteração da variável de contagem das peças

                System.out.println("Produzido " + Value);
                queue.add(Value); //Adição da variável à fila de espera
                this.notify(); //Libertação para a outra thread
            }
            i++; //Iterador do While principal
        }
    }

    public void consu(int iter) throws InterruptedException { //Método consumidor
        while (i < iter) {
            synchronized (this) { //Bloco sincronizado
                while (queue.size() == 0) { //Se a fila de espera não tiver valores
                    this.wait(); //Thread suspensa até que a condição mude
                }

                int tmpValue = queue.poll(); //Lê e retira o valor em fila de espera
                System.out.println("Consumido " + tmpValue);
                this.notify(); //Libertação para a outra thread
            }
        }
    }
}
