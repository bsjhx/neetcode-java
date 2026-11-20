package pl.bsjhx.katas.threads;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    public static void main(String[] args) throws InterruptedException {
        var bankAccount = new BankAccount();

        List<Thread> threads = new ArrayList<>(20);

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 10_000; j++) {
                    bankAccount.deposit(10);
                }
            }));
        }

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 10_000; j++) {
                    bankAccount.withdraw(10);
                }
            }));
        }

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final balance: " + bankAccount.getBalance());

    }

    private int balance = 1000;

    private final Object lock = new Object();

    void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    void withdraw(int amount) {
        synchronized (lock) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds for withdrawal of " + amount);
            }
        }
    }

    int getBalance() {
        synchronized (lock) {
            return balance;
        }
    }
}
