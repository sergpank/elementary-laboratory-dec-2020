package com.hillel;

public class CustomMessageProvider implements MessageProvider
{
    private String message;

    public CustomMessageProvider(String message)
    {
        System.out.println("constructor :: message provider");
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
