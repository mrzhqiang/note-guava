package com.github.mrzhqiang.basic;

import com.github.mrzhqiang.data.Person;
import com.github.mrzhqiang.data.SimplePerson;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.github.mrzhqiang.Main.PREFIX;
import static com.github.mrzhqiang.Main.show;

/**
 * <a href="https://github.com/google/guava/wiki/OrderingExplained">OrderingExplained</a>
 */
public class OrderingPractice {
  public static void main(String[] args) {
    /*
     * Guava's powerful "fluent Comparator" class.
     * */
    PREFIX = "OrderingPractice";

    // 1. Creation
    // 自然排序
    show(Ordering.natural().sortedCopy(Lists.newArrayList("11", "21", "12")));
    // toString的字典排序
    show(Ordering.usingToString().max("abccC", "abccc"));
    // 简单使用
    //Ordering.from();
    // 但一般可以跳过一个Comparator，直接使用Ordering
    Ordering<String> byLengthOrdeing = new Ordering<String>() {
      @Override public int compare(String left, String right) {
        return Ints.compare(left.length(), right.length());
      }
    };
    show(byLengthOrdeing.max("1111", "222"));

    // 2.Chaining
    // 逆向排序
    List<String> strings = Lists.newArrayList("1", "2", "21", "223");
    show(Ordering.natural().reverse().sortedCopy(strings));
    // null元素小于其他任何值，相反的是，nullsLast
    strings.add(3, null);
    show(Ordering.natural().nullsFirst().sortedCopy(strings));
    // 断开连接？
    List<SimplePerson> personList = new ArrayList<>();
    for (int i = 10; i < 20; i++) {
      personList.add(SimplePerson.newRandom(i));
    }
    show(Ordering.compound(personList).reverse());
    // 很奇怪的方法
    Ordering.natural().lexicographical();

    // 对一个类进行比较，总好过于将此类声明为比较器接口
    // 但是真的不清楚怎么使用
    Ordering<Person> personOrdering = Ordering.natural().nullsFirst().onResultOf((Function<Person, String>) Person::toString);
    show(personOrdering);
    // 难道只是用来产生比较器，还需要额外的比较数据源？
    show(personOrdering.max(Person.random(10), Person.random(20)));

    // 列出受欢迎的方法
    // greatestOf isOrdered sortedCopy min max
  }
}
