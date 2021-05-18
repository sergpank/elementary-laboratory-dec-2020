package com.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLock
{
    private static final Logger log = LoggerFactory.getLogger(DeadLock.class);

    public static void main(String[] args)
    {
        final BlockThread t1 = new BlockThread();
        final BlockThread t2 = new BlockThread();

        t1.setOtherThread(t2);
        t2.setOtherThread(t1);

        t1.start();
        t2.start();
    }
}
