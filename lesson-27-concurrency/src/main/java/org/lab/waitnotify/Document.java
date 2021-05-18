package org.lab.waitnotify;

import java.util.Date;

public class Document
{
    private Printer printer = new Printer();

    public void printDocument() throws InterruptedException
    {
        System.out.println("Printing started ...");

        Runnable r = () -> printer.print(5, this);
        new Thread(r).start();

        synchronized (this)
        {
            while (!printer.isDone())
            {
                System.out.println("waiting for printer ... " + new Date());
                wait();
                System.out.println("waiting is over!");
            }
        }

        System.out.println("Printing is done.");
    }
}
