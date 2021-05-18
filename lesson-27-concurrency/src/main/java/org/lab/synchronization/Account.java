package org.lab.synchronization;

class Account
{
    private int balance;

    public Account(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return balance;
    }

    public void addFunds(int amount)
    {
        System.out.println("START ADD");
        balance += amount;
        System.out.println("END ADD");
    }

    public void withdrawFunds(int amount)
    {
        System.out.println("START REMOVE");
        balance -= amount;
        System.out.println("END ADD");
    }
}
