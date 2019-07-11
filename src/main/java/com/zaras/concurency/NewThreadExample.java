package com.zaras.concurency;

import java.time.LocalTime;

public class NewThreadExample {
    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        },"timeThread");
        timeThread.start();
        Thread helloThread = new Thread(() -> {
            while (true) {
                System.out.println("Hello World");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    return;
                }
            }
        },"helloThread");
        helloThread.start();

        System.out.println("Main: I'm done gonna outta here.");
    }
}
