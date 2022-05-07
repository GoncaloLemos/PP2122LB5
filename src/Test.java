/*
 * Copyright © 2022, Pedro S.. All rights reserved.
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Scanner Scanner = new Scanner(System.in);
        System.out.println("Number Of Pieces To Produce ");
        int pieces = Scanner.nextInt();
        WorkerProcess worker = new WorkerProcess();
        Thread t1 = new Thread(() -> {
            try {
                worker.produce(pieces);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                worker.consume(pieces);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Completed.");
    }
}
