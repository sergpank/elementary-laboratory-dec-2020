package org.lab.waitnotify;

import java.util.concurrent.TimeUnit;

public class Printer
{
    private boolean done;

    public void print(int sec, Document document)
    {
        System.out.println("Printing is started");
        done = false;
        try
        {
            for (int i = 0; i < sec; i++)
            {
                System.out.println("... printing");
                TimeUnit.SECONDS.sleep(1);
                synchronized (document){
                    document.notify();
                }
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Printing is done");
        done = true;
        synchronized (document)
        {
            document.notify();
        }
    }

    public boolean isDone()
    {
        return done;
    }
}
