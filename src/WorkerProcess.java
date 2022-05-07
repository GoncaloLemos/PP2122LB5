/*
 * Copyright © 2022, Pedro S.. All rights reserved.
 */

public class WorkerProcess extends Thread {

    Object queued = null;
    int count = 0;
    int i;

    public void produce(int iter) throws InterruptedException {
        while (i < iter) {
            synchronized (this) {
                while (queued != null) {
                    this.wait();
                }
                count++;
                System.out.println("Produced: " + count);
                queued = count;
                this.notify();
            }
            i++;
        }
    }

    public void consume(int iter) throws InterruptedException {
        while (i < iter) {
            synchronized (this) {
                while (queued == null) {
                    this.wait();
                }
                System.out.println("Consumed: " + queued);
                queued = null;
                this.notify();
            }
        }
    }
}
