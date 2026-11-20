package pl.bsjhx.katas.threads;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(createTask("Task 1"));
        var thread2 = new Thread(createTask("Task 2"));
        var thread3 = new Thread(createTask("Task 3"));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("All tasks completed");

    }

    private static Runnable createTask(String taskName) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.printf("%s | %s | iteration: %d%n", taskName, Thread.currentThread().getName(), i);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
