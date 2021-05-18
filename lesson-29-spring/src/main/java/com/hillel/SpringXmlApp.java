package com.hillel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlApp
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        MessageRenderer renderer = ctx.getBean(MessageRenderer.class);
        renderer.render();
    }
}
