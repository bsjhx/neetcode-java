package pl.bsjhx.katas.threads;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {
        var task = new Thread(createTask());
        task.start();
        Thread.sleep(2000);
        task.interrupt();
        task.join();

        System.out.println("Task terminated");
    }

    private static Runnable createTask() {
        return () -> {
            for (int i = 0; i < 100; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted");
                    return;
                }
                System.out.printf("%s | iteration: %d%n", Thread.currentThread().getName(), i);


                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };
    }
}
