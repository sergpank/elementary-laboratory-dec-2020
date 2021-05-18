package com.hillel.config;

import com.hillel.ConsoleMessageRenderer;
import com.hillel.CustomMessageProvider;
import com.hillel.MessageProvider;
import com.hillel.MessageRenderer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.hillel"})
public class JavaContext
{
//    @Bean
//    public MessageProvider messageProvider()
//    {
//        System.out.println("config :: message provider");
//        return new CustomMessageProvider("~~~ !!! MY_CUSTOM_MESSAGE !!! ~~~");
//    }
//
//    @Bean
//    public MessageRenderer messageRenderer()
//    {
//        System.out.println("config :: message renderer");
//        return new ConsoleMessageRenderer(messageProvider());
//    }
}
