package com.fpinjava.makingjavafunctional.exercise03_11;

import java.util.ArrayList;
import java.util.List;


public class Range {

  public static List<Integer> range(int start, int end) {
    final List<Integer> list = new ArrayList<>();

    for (int i = start; i < end; i++) {
      list.add(i);
    }

    return list;
  }
}
