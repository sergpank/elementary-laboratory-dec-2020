package com.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

class BlockThread extends Thread
{
    private static Logger log = LoggerFactory.getLogger(BlockThread.class);
    BlockThread otherThread;
    boolean busy;

    public void setOtherThread(BlockThread otherThread)
    {
        this.otherThread = otherThread;
    }

    public boolean isBusy()
    {
        return busy;
    }

    @Override
    public void run()
    {
        log.info("Blocking thread started ...");
        otherThread.doSmth();
        log.info("Blocking thread terminated ...");
    }

    public void doSmth()
    {
        busy = true;
        try
        {
            TimeUnit.SECONDS.sleep(1);
            while (otherThread.isBusy())
            {
                sleep(1);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        busy = false;
    }
}
