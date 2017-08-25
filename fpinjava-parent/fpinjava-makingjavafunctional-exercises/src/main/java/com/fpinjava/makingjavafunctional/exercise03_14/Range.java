package com.fpinjava.makingjavafunctional.exercise03_14;

import static com.fpinjava.makingjavafunctional.exercise03_13.CollectionUtilities.list;
import static com.fpinjava.makingjavafunctional.exercise03_13.CollectionUtilities.prepend;

import java.util.List;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return end <= start
        ? list()
        : prepend(start, range(start + 1, end));
  }
}
