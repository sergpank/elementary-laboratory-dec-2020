package com.hillel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMessageRenderer implements MessageRenderer
{
    private MessageProvider provider;

    @Autowired
    public ConsoleMessageRenderer(MessageProvider provider)
    {
        System.out.println("constructor :: message renderer");
        this.provider = provider;
    }

    @Override
    public void render()
    {
        System.out.println(provider.getMessage());
    }
}
