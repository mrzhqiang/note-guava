package com.github.mrzhqiang.data;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

public class SimplePerson extends Person
    implements Comparable<SimplePerson>, Comparator<SimplePerson> {

  private SimplePerson(@Nonnull Person person) {
    super(person.name, person.age);
  }

  public static SimplePerson newRandom(int size) {
    return new SimplePerson(Person.random(size));
  }

  @Override public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("age", age)
        .toString();
  }

  @Override public int compareTo(SimplePerson o) {
    // 内部的实现，令人眼前一亮
    return ComparisonChain.start()
        .compare(this.name, o.name)
        .compare(this.age, o.age)
        .result();
  }

  @Override public int compare(SimplePerson o1, SimplePerson o2) {
    checkNotNull(o1);
    checkNotNull(o2);
    return o1.compareTo(o2);
  }
}
