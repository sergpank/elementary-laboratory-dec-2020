package com.hillel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
  private static final Logger log = LoggerFactory.getLogger(LogTest.class);

  public static void main(String[] args) {
    log.error("error message");
    log.warn("warning message");
    log.info("info message");
    log.debug("debug message");
    log.trace("trace message");
  }
}
