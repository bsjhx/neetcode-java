package pl.bsjhx.katas.threads;

public class Task5 {

    private static int value = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            value = 42;
        });

        Thread reader = new Thread(() -> {
            System.out.println(value);
        });

        writer.start();
        reader.start();

        reader.join();
        writer.join();
    }
}
