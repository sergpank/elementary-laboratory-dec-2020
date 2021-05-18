package com.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo
{
    private static Logger log = LoggerFactory.getLogger(CallableDemo.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        List<Future<Integer>> results = new ArrayList<>();
        final ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i += 10)
        {
            final int start = i;

            Callable<Integer> c = () ->
            {
                log.info("calc started ...");
                int sum = 0;
                for (int j = start; j <= start + 9; j++)
                {
                    sum += j;
                }

                return sum;
            };

            results.add(pool.submit(c));
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        int sum = 0;
        for (Future<Integer> f : results)
        {
            sum += f.get();
        }

        log.info("result = {}", sum);
    }
}
