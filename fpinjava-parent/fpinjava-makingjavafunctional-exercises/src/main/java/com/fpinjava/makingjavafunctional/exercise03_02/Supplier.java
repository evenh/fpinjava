package com.fpinjava.makingjavafunctional.exercise03_02;

@FunctionalInterface
public interface Supplier<T> {
  T get();
}
