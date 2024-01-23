package ru.kolesnik;

public class MyThread extends Thread {

    private final String first;
    private final String second;

    public MyThread(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            processResource(first);

            synchronized (second) {
                processResource(second);
            }
        }
    }

    private static void processResource(String resource) {
        try {
            System.out.printf("Thread '%s' locked resource: '%s'%n", Thread.currentThread(), resource);
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
