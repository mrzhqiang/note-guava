package com.github.mrzhqiang.basic;

import com.github.mrzhqiang.data.Person;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import javax.annotation.Nonnull;

import static com.github.mrzhqiang.Main.PREFIX;
import static com.github.mrzhqiang.Main.show;

/**
 * <a href="https://github.com/google/guava/wiki/CommonObjectUtilitiesExplained">CommonObjectUtilitiesExplained</a>
 */
final class ObjectCommon {

  public static void main(String[] args) {
    /*
     * Simplify implementing Object methods, like hashCode() and toString().
     * */

    PREFIX = "Object common methods";
    // 1. equals
    show(Objects.equal("a", "a"));
    show(Objects.equal(null, "a"));
    show(Objects.equal("a", null));
    show(Objects.equal(null, null));
    // 以上方法，在 JDK 7 中，有对等的实现：Objects.equals
    // 另外，JDK 7 提供了深度比较的方法，也即是对各种基本类型的数组对象，进行逐级比较
    // 主要的实现在 JDK 7 的Arrays这个类中

    // 2. hashCode
    // 这部分的实现可以在 data 包下的 Person 找到
    // 这里列出简单的实现
    show(Objects.hashCode(1, 2, 3, 4));
    // 以上方法，在 JDK 7 中，有对等的实现：Objects.hash

    // 3. toString
    // 说实话，写toString方法，真心烦躁，那么Guava又有怎样的工具方法呢？
    // 首先看烦躁的样例，比如 data.Person 里面的实现
    show(Person.random(10));
    // 不仅写得很累，而且难以阅读，后续扩展也不灵活，这里尝试用MoreObjects.toStringHelper
    show(SimplePerson.newRandom(10));

    // 4. compare/compareTo
    // 参见SimplePerson的实现
    // 还有更厉害的比较器，未来再看，这里给出标识符，以备随时检阅：Ordering

    /*
    * 虽然对于 toString 、 hashCode 以及 equals ，有一门语言已经完全隐蔽了——Kotlin
    * 但有时候，在你还不熟悉Kotlin的情况下，在你还需要Java语言，来跟其他同事沟通的情况下，
    * 你必须有一个好工具，来处理这些糟糕的事情，所以用Guava吧，少年！
    * */
  }

  static final class SimplePerson extends Person implements Comparable<SimplePerson> {

    private SimplePerson(@Nonnull Person person) {
      super(person.name, person.age);
    }

    public static Person newRandom(int size) {
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
  }
}
