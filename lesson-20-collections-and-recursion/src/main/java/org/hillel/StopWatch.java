package org.hillel;

public class StopWatch {
  private static long start;

  public static void start() {
    start = System.currentTimeMillis();
  }

  public static long stop() {
    return System.currentTimeMillis() - start;
  }
}
