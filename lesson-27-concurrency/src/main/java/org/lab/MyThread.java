package org.lab;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread
{
    private int cnt;

    public MyThread(int cnt)
    {
        this.cnt = cnt;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= cnt; i++)
        {
            if (isInterrupted())
            {
                break;
            }
            String threadName = Thread.currentThread().getName();
            System.out.printf("Thread [%s] is Running ... %d\n", threadName, i);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
