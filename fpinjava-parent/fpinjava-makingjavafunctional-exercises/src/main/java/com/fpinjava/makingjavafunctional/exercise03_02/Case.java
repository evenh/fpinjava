package com.fpinjava.makingjavafunctional.exercise03_02;

import com.fpinjava.common.Tuple;
import com.fpinjava.makingjavafunctional.exercise03_01.Result;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {

  private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
    super(booleanSupplier, resultSupplier);
  }

  public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
    return new Case<>(condition, value);
  }

  public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
    final Supplier<Boolean> conditionSupplier = () -> true;

    return new DefaultCase<>(conditionSupplier, value);
  }

  private static class DefaultCase<T> extends Case<T> {
    private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
      super(booleanSupplier, resultSupplier);
    }
  }

  @SafeVarargs
  public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
    for (Case<T> currentCase : matchers) {
      if (currentCase._1.get()) {
        return currentCase._2.get();
      }
    }

    return defaultCase._2.get();
  }
}
