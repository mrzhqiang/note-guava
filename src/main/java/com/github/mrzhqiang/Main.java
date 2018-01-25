package com.github.mrzhqiang;

import javax.annotation.Nullable;

public class Main {
  public static String PREFIX = "Guava";

  public static void show(@Nullable Object object) {
    System.out.println("[" + PREFIX + "]: " + object);
  }
}
