package pl.bsjhx.katas.threads;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {
        var worker = new Worker();
        worker.start();

        Thread.sleep(1_000);

        worker.stop();

    }

    static class Worker {

        private volatile boolean running = true;

        public void start() {
            Thread worker = new Thread(() -> {
                System.out.println("Worker started");

                while (running) {
                    // intentionally empty
                }

                System.out.println("Worker stopped");
            });

            worker.start();
        }

        public void stop() {
            running = false;
        }
    }
}
