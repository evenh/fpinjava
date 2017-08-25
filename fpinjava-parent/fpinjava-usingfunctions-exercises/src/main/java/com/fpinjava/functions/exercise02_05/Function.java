package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

  U apply(T arg);

  static <T, U, V> Function<Function<U, V>,
                   Function<Function<T, U>,
                            Function<T, V>>> higherCompose() {
    return x -> y -> v -> x.apply(y.apply(v));
  }
}
