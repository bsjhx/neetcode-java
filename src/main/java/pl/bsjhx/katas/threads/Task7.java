package pl.bsjhx.katas.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task7 {

    public static void main(String[] args) throws InterruptedException {
        var executor = Executors.newFixedThreadPool(2);
        executor.submit(getTask());
        executor.submit(getTask());
        executor.submit(getTask());
        executor.submit(getTask());
        executor.submit(getTask());

        executor.shutdown();

        boolean terminated = executor.awaitTermination(1, TimeUnit.SECONDS);

        if (!terminated) {
            System.out.println("Executor did not terminate in the specified time.");
            executor.shutdownNow();
        } else {
            System.out.println("Executor terminated successfully.");
        }

        terminated = executor.awaitTermination(1, TimeUnit.SECONDS);

        if (terminated) {
            System.out.println("Executor terminated successfully after shutdownNow.");
        } else {
            System.out.println("Executor did not terminate after shutdownNow.");
        }

    }

    private static Runnable getTask() {
        return () -> {
            long end = System.currentTimeMillis() + 3000;

            while (System.currentTimeMillis() < end) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("I was interrupted!");
                    return;
                }
            }
        };
    }
}
