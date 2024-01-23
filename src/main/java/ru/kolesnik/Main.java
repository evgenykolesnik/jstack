package ru.kolesnik;

import java.util.Map;

public class Main {

    private static final Map<String, Boolean> modes = Map.of(
            "normal", true,
            "deadlock", false
    );

    public static void main(String[] args) {
        if (args.length != 1 && !modes.containsKey(args[0])) {
            System.out.printf("The program should have exact one argument, one of: %s%n", modes.keySet());
            return;
        }

        run(modes.get(args[0]));
    }

    private static void run(boolean mode) {
        Thread thread1 = new MyThread("first", "second");
        Thread thread2;

        if (mode) {
            thread2 = new MyThread("first", "second");
        } else {
            thread2 = new MyThread("second", "first");
        }

        thread1.start();
        thread2.start();
    }
}
