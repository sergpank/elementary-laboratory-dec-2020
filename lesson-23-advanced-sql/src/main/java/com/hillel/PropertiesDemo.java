package com.hillel;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
  public static void main(String[] args) throws IOException
  {
    final Properties props = new Properties();

    props.load(new FileReader("src/main/resources/demo.properties"));

    final String firstName = props.getProperty("first.name");

    System.out.println(firstName);
  }
}
