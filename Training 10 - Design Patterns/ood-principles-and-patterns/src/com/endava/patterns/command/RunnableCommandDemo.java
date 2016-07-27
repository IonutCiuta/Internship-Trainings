package com.endava.patterns.command;

public class RunnableCommandDemo {

    public static void main(String[] args) {

        Task task1 = new Task(11,2); //aka encapsulates request
        Task task2 = new Task(10,3);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start(); //aka invoker
        thread2.start();
    }
}

class Task implements Runnable { //aka Command interface

    private int x, y;

    public Task(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() { //aka execute
        System.out.println(x * y); //aka receiver
    }
}
