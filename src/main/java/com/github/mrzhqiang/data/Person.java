package com.github.mrzhqiang.data;

import com.google.common.base.Objects;
import java.security.SecureRandom;
import java.util.Random;
import javax.annotation.Nonnull;

public class Person {
  private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final Random RANDOM = new SecureRandom();

  public static Person random(int nameSize) {
    StringBuilder builder = new StringBuilder(nameSize);
    for (int i = 1; ; i++) {
      int index = RANDOM.nextInt(CHARS.length());
      builder.append(CHARS.charAt(index));
      if (i == nameSize) {
        return new Person(builder.toString(), index);
      }
    }
  }

  private static final Person EMPTY = new Person("", 0);

  public static Person empty() {
    return EMPTY;
  }

  public final String name;
  public final int age;

  public Person(@Nonnull String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Person)) {
      return false;
    }
    Person person = (Person) obj;
    return Objects.equal(name, person.name) && age == person.age;
  }

  @Override public int hashCode() {
    return Objects.hashCode(name, age);
  }

  @Override public String toString() {
    return "[" + this.getClass().getSimpleName() + "](name=" + name + ", age=" + age + ")";
  }

  public boolean isEmpty() {
    return this.equals(EMPTY);
  }
}
