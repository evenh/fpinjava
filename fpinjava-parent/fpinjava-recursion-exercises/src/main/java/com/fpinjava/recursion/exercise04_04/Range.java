package com.fpinjava.recursion.exercise04_04;

import static com.fpinjava.common.CollectionUtilities.append;

import com.fpinjava.common.TailCall;
import java.util.Collections;
import java.util.List;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return range_(Collections.emptyList(), start, end).eval();
  }

  public static TailCall<List<Integer>> range_(List<Integer> acc, Integer start, Integer end) {
    return end <= start
        ? TailCall.ret(acc)
        : TailCall.sus(() -> range_(append(acc, start), start + 1, end));
  }
}
