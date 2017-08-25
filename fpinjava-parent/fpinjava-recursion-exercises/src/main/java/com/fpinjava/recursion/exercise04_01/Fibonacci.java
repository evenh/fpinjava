package com.fpinjava.recursion.exercise04_01;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;

public class Fibonacci {

  public static BigInteger fib(int x) {
    return fib_(ONE, ZERO, BigInteger.valueOf(x));
  }

  private static BigInteger fib_(BigInteger acc1, BigInteger acc2, BigInteger x) {
    return x.equals(ZERO)
        ? ZERO
        : x.equals(ONE)
          ? acc1.add(acc2)
          : fib_(acc2, acc1.add(acc2), x.subtract(ONE));
  }
}
