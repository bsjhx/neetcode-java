package pl.bsjhx.katas.threads;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    private static final int NUMBER_OF_TASKS = 10;
    private static final int NUMBER_OF_ITERATIONS = 100_000;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> tasks = new ArrayList<>(NUMBER_OF_TASKS);
        var counter = new Counter();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            tasks.add(new Thread(createTask(NUMBER_OF_ITERATIONS, counter, false)));
        }

        tasks.forEach(Thread::start);
        for (Thread task : tasks) {
            task.join();
        }

        System.out.println("Expected counter value: " + (NUMBER_OF_TASKS * NUMBER_OF_ITERATIONS));
        System.out.println("Actual counter value: " + counter.getValue());
        System.out.println("Difference: " + (NUMBER_OF_TASKS * NUMBER_OF_ITERATIONS - counter.getValue()));

    }

    private static Runnable createTask(int n, Counter counter, boolean debug) {
        return () -> {
            for (int i = 0; i < n; i++) {
                counter.increment();
                if (debug) {
                    System.out.printf("%s | iteration: %d | counter: %d%n", Thread.currentThread().getName(), i, counter.getValue());
                }
            }
        };
    }

    static class Counter {

        private int value = 0;

        public synchronized void increment() {
            value++;
        }

//        Wrong - lack of synchronization can lead to race conditions and incorrect results
//        public void increment() {
//            value++;
//        }

        public int getValue() {
            return value;
        }
    }
}
