package com.github.mrzhqiang;

import java.util.Locale;
import javax.annotation.Nullable;

public class Main {
  public static String PREFIX = "Guava";

  public static void show(@Nullable Object object) {
    System.out.println("[" + PREFIX + "]: " + object);
  }

  public static void main(String[] args) {
    System.out.println(Locale.getDefault());
    testNMEA();
    testGPS();
  }

  private static String data =
      "$GPGGA,050914.09,3114.9371,N,12040.1501,E,0,,100.000,-92.458,M,,M,0,*54";

  public static void testNMEA() {
    char[] chars = data.toCharArray();
    int code = chars[1];
    for (int i = 2; chars[i] != '*'; i++) {
      code ^= chars[i];
    }
    System.out.println(Integer.parseInt(data.substring(data.indexOf("*") + 1)));
    System.out.println(String.format("%x", code));
  }

  public static void testGPS() {
    double du = 121;
    double fen = 20;
    double miao = 37.068;
    double result = du + fen / 60 + miao / 60 / 60;
    System.out.println(result);
  }
}
