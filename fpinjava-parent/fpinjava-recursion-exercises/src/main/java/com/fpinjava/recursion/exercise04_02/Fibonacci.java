package com.fpinjava.recursion.exercise04_02;

import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import com.fpinjava.common.TailCall;
import java.math.BigInteger;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return fib_(ONE, ZERO, BigInteger.valueOf(x)).eval();
  }

  private static TailCall<BigInteger> fib_(BigInteger acc1, BigInteger acc2, BigInteger x) {
    return x.equals(ZERO)
        ? ret(ZERO)
        : x.equals(ONE)
            ? ret(acc1.add(acc2))
            : sus(() -> fib_(acc2, acc1.add(acc2), x.subtract(ONE)));
  }
}
