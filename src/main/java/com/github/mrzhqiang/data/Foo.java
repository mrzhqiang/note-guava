package com.github.mrzhqiang.data;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class Foo {
  final ImmutableSet<Bar> bars;

  public Foo(Set<Bar> bars) {
    // defensive copy!
    this.bars = ImmutableSet.copyOf(bars);
  }

  public static class Bar {
    public final String name;

    public Bar(String name) {
      this.name = name;
    }
  }
}
