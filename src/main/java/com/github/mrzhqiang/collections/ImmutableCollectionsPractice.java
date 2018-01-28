package com.github.mrzhqiang.collections;

import com.github.mrzhqiang.data.Foo;
import com.google.common.collect.ImmutableSet;

/**
 * <a href="https://github.com/google/guava/wiki/ImmutableCollectionsExplained">ImmutableCollectionsExplained</a>
 */
public class ImmutableCollectionsPractice {

  public static void main(String[] args) {
    /*
     * Immutable collections, for defensive programming, constant collections, and improved efficiency.
     * */

    // 1. Example
    final ImmutableSet<String> COLOR_NAMES =
        ImmutableSet.of("RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE");
    /**
     * 另外一个样例，需要参见下面的链接。这里稍微有点破坏JavaDoc注释结构，
     * 但由于这个仓库只是一个学习笔记，因此不具备实际的破坏性。
     * @see Foo
     * */

    // 2. Why？
    // 文档居然嫌弃在JDK中，有关 Collections.unmodifiableXXX 的实现。简直看醉了。

    
  }
}
