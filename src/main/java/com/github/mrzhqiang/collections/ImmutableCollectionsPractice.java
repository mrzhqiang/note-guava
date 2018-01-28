package com.github.mrzhqiang.collections;

import com.github.mrzhqiang.Main;
import com.github.mrzhqiang.data.Foo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * <a href="https://github.com/google/guava/wiki/ImmutableCollectionsExplained">ImmutableCollectionsExplained</a>
 */
public class ImmutableCollectionsPractice {

  public static void main(String[] args) {
    /*
     * Immutable collections, for defensive programming, constant collections, and improved efficiency.
     * */
    Main.PREFIX = "ImmutableCollectionsPractice";

    // 1. Example
    final ImmutableSet<String> COLOR_NAMES =
        ImmutableSet.of("RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE");
    /**
     * 另外一个样例，需要参见下面的链接。这里稍微有点破坏JavaDoc注释结构，
     * 但由于这个仓库只是一个学习笔记，因此不具备实际的破坏性。
     * @see Foo
     * */

    // 2. Why？
    // 文档居然嫌弃JDK中，有关 Collections.unmodifiableXXX 的实现。简直看醉了。

    // 3. How？
    Main.show(ImmutableSet.copyOf(new String[] {"one", "two", "three"}));
    Main.show(ImmutableList.of("a", "c", "b"));
    Main.show(ImmutableMap.of("a", 1, "b", 2));
    Main.show(ImmutableSet.<String>builder().addAll(COLOR_NAMES).add("BLACK").build());
    // 不接受相同的值？Set集合本身就不接受重复值
    Main.show(ImmutableSet.of("a", "b", "c", "a", "d", "b"));

    // 其他的一些撰述，留待未来探索
  }
}
