package com.hillel;

import com.hillel.config.JavaContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaApp
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaContext.class);
        MessageRenderer renderer = ctx.getBean(MessageRenderer.class);
        renderer.render();
    }
}
