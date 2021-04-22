package org.hillel;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Factorial {
  private static long cnt;

  public static void main(String[] args) {
    for (BigInteger i = ZERO; i.compareTo(BigInteger.valueOf(100)) <= 0; i = i.add(ONE)) {
      StopWatch.start();
      BigInteger factorial = factorial(i);
      long duration = StopWatch.stop();
      System.out.printf("%d :: %d (cnt = %d) (%d ms)\n", i, factorial, cnt, duration);
      cnt = 0;
    }
  }

  private static BigInteger factorial(BigInteger i) {
    if ( i.compareTo(ZERO) == 0) {
      return ONE;
    }
    cnt++;
    return i.multiply(factorial(i.subtract(ONE)));
  }
}
