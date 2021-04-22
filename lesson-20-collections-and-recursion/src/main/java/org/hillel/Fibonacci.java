package org.hillel;

public class Fibonacci {
  private static long cnt;

  public static void main(String[] args) {
    for (long i = 0; i <= 45; i++) {
      StopWatch.start();
      long fibonacci = fibonacci(i);
      long duration = StopWatch.stop();
      System.out.printf("fib(%d) = %d; cnt = %d; %d ms\n", i, fibonacci, cnt, duration);
      cnt = 0;
    }
  }

  private static long fibonacci(long i) {
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }
    cnt++;
    return fibonacci(i - 1) + fibonacci(i - 2);
  }
}
