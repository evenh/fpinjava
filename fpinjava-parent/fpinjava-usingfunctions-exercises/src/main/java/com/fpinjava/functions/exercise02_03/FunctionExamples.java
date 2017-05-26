package com.fpinjava.functions.exercise02_03;


public class FunctionExamples {

  public static final Function<Integer, Function<Integer, Integer>> add = first -> second -> first + second;

  public static final BinaryOperator add2 = first -> second -> first + second;

  public static final BinaryOperator mult =  first -> second -> first * second;
}
