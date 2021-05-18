package org.lab.synchronization;

import java.util.ArrayList;
import java.util.List;

public class AccountProcessor
{
    public static void main(String[] args) throws InterruptedException
    {
        final long start = System.currentTimeMillis();
        Account account = new Account(100);
        List<Thread> threads = new ArrayList<>();

        Runnable r = () ->
        {
            for (int i = 0; i < 10_000; i++) {
                synchronized (account)
                {
                    account.addFunds(10);
                    account.withdrawFunds(10);
                }
            }
            System.out.printf("Thread [%s] execution is over ; balance = %d\n",
                Thread.currentThread().getName(), account.getBalance());
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(r);
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final balance = " + account.getBalance());

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
