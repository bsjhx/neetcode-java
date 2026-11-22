package pl.bsjhx.katas.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Task6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        try (var executorService = Executors.newFixedThreadPool(3)) {
//            for (int i = 0; i < 10; i++) {
//                int finalI = i;
//                executorService.submit(() -> {
//                    System.out.printf("id: %d%n", finalI);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        return;
//                    }
//                    System.out.printf("done: %d%n", finalI);
//                });
//            }
//        }

        try (var executor = Executors.newFixedThreadPool(2)) {
            var future = executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                throw new RuntimeException("test");
            });


            System.out.println(future.isDone());
            executor.shutdown();
            future.get();

            System.out.println(future.isDone());

        }
    }
}
