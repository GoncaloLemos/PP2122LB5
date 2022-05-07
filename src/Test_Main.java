//AUTOR 30000497 ANTÓNIO GRAÇA

import java.util.Scanner;

public class Test_Main {
    public static void main(String args[]) throws InterruptedException {

        Scanner scan = new Scanner(System.in); //Scanner de input
        System.out.println("Digite o número de peças: ");
        int pieces = scan.nextInt(); //Lê o integer que o utilizador introduziu

        QList prodcons = new QList(); //Criação do objeto

        Thread t1 = new Thread(() -> { //Criação de Thread produtora com expressão Lambda
            try {
                prodcons.produ(pieces); //Chamada ao método produtor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> { //Criação de Thread consumidora com expressão Lambda
            try {
                prodcons.consu(pieces); //Chama ao método consumidor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start(); //Inicio de thread
        t2.start(); //Inicio de thread

        System.out.println("O programa terminou!"); //FIM DO PROGRAMA
    }
}
