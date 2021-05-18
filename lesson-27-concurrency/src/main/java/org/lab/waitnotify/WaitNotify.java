package org.lab.waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitNotify
{
    boolean teaReady;
    boolean omeletReady;
    boolean toastReady;

    enum Dish {
        TEA,
        OMELET,
        TOAST
    }

    public static void main(String[] args) {
        WaitNotify n = new WaitNotify();
        Runnable teaCooker = n.makeCooker(Dish.TEA, 1);
        Runnable toastCooker = n.makeCooker(Dish.TOAST, 2);
        Runnable omeletCooker = n.makeCooker(Dish.OMELET, 3);
        Runnable vasya = n.makeEater("Вася");
        Runnable petya = n.makeEater("Петя");

        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(vasya);
        pool.execute(petya);
        pool.execute(teaCooker);
        pool.execute(toastCooker);
        pool.execute(omeletCooker);

        pool.shutdown();
    }

    Runnable makeCooker(Dish dish, long delay) {
        return () -> {
            System.out.printf("Start cooking [%s] ...\n", dish.name());

            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (Throwable t) {
                // NOTHING TO DO HERE
            }

            System.out.printf("[%s] is ready!\n", dish.name());

            switch (dish) {
                case TEA  : teaReady   = true; break;
                case OMELET: omeletReady = true; break;
                case TOAST: toastReady = true; break;
            }
            synchronized (this) {
                notifyAll();
            }
        };
    }

    Runnable makeEater(String name) {
        return () -> {
            while (!catTakeBreakfast()) {
                System.out.printf("%s : Waiting for my breakfast ...\n", name);
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.printf("%s : FINALLY! num - num - num !\n", name);
        };
    }

    boolean catTakeBreakfast() {
        return teaReady && omeletReady && toastReady;
    }
}
