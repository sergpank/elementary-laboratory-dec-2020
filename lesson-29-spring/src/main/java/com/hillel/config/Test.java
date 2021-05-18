package com.hillel.config;

public class Test
{
    static Animal a;
    public static void main(String[] args)
    {
        int __x = 10;
        System.out.println(__x);
        System.out.println(a.DOG.sound);

        Boolean [] b  = {true, false};
    }
}

enum Animal {
    DOG("gav"),
    CAT("meow");

    String sound;

    Animal(String s)
    {
        this.sound = s;
    }
}
