package com.hillel;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableThreadPools
{
    private static final Logger log = LogManager.getLogger(CallableThreadPools.class);

    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        final StopWatch sw = new StopWatch();
        long cnt = 0;

        sw.start("single count");
        log.info("count started ...");
        for (long i = 1; i <= 16_000_000_000L; i++ )
        {
            cnt++;
        }
        log.info("count = {}", cnt);
        sw.stop();
        log.info("calc took {} ms", TimeUnit.NANOSECONDS.toMillis(sw.getLastTaskTimeNanos()));

        sw.start("pool count");
        long totalCnt = 0;
        log.info("Available processors: {}", Runtime.getRuntime().availableProcessors());
        log.info("Pool count started ...");

        List<Future<Long>> futures = new ArrayList<>();
        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 1; i <= 16; i++)
        {
            futures.add(pool.submit(createCounter(1_000_000_000L)));
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        for (Future<Long> f : futures)
        {
            totalCnt += f.get();
        }
        log.info("Pool count = {}", totalCnt);
        sw.stop();
        log.info("calc took {} ms", TimeUnit.NANOSECONDS.toMillis(sw.getLastTaskTimeNanos()));

        log.info("\n" + sw.prettyPrint());
    }

    public static Callable<Long> createCounter(long limit)
    {
        return new Callable<Long>()
        {
            @Override
            public Long call()
            {
                long cnt = 0;
                for (long i = 1; i <= limit; i++ )
                {
                    cnt++;
                }
                return cnt;
            }
        };
    }
}
