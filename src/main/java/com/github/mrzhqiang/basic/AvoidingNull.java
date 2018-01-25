package com.github.mrzhqiang.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

import static com.github.mrzhqiang.Main.*;

/**
 * <a href="https://github.com/google/guava/wiki/UsingAndAvoidingNullExplained">UsingAndAvoidingNullExplained</a>
 */
final class AvoidingNull {

  public static void main(String[] args) {
    /*
     * null can be ambiguous, can cause confusing errors, and is sometimes just plain unpleasant.
     * Many Guava utilities reject and fail fast on nulls, rather than accepting them blindly.
     * */
    PREFIX = "Specific Cases";
    // 这一段看不懂，用有道词典和谷歌翻译了好几遍也是一样。
    // 大概可能是在讲，一些null的不正当使用会造成什么后果，以及推荐使用Guava的Lists吧。
    List<Object> objects = Collections.unmodifiableList(Lists.newArrayList());
    show(objects);
    PREFIX = "Optional";
    // 就是在说，可选的什么什么鬼？
    // 不太明白。不过与Kotlin很类似的用法，倒是一种编程界的流行趋势。
    Optional<Integer> possible = Optional.of(5);
    show(possible.isPresent());
    show(possible.get());
    PREFIX = "Making an Optional";
    // 传入非null值，直接创建Optional的扩展类Present对象；null值则会立即失败。
    show(Optional.of("Hello,Guava!"));
    // 生成一个“不存在”的Optional类，意味着，null值如果被这个生成值取代，那么可以避免空指针。
    show(Optional.absent());
    // 如果传入null值，则相当于调用 Optional.absent()；如果传入的值非null，则 new Present
    show(Optional.fromNullable(null));
    // 一些猜测：
    // 大概可能是从代码中，剥离null的存在。
    // 比如，将一些可能引用为null的对象，通过一个Optional包装起来。
    // 这样，假若对象变成null，会得到警告；可以增强代码的健壮性？

    PREFIX = "Query methods";
    Optional<String> optional = Optional.of(PREFIX);
    // 判断是否为“存在”，如果是，返回true，否则返回false
    show(optional.isPresent());
    // 返回可选的实例，实例必须存在，否则将会抛出 IllegalStateException
    show(optional.get());
    // 如果实例存在，就返回；否则返回给定的默认值
    show(optional.or("Default Value"));
    show(Optional.absent().or(optional));
    // 如果实例不存在，返回 null
    show(Optional.absent().orNull());
    // 返回单个Set
    show(optional.asSet());

    // What's the point?
    // 使用Optional可以迫使其他开发者，主动打开这个可选的对象，类似薛定谔的猫，在打开的一瞬间，
    // 才知道它是否为null。比其他运行时检查更先进的是，它在准备使用“不存在”对象——Absent时，
    // 比如get方法，将抛出一系列异常，而对于“存在”的对象——Present，则是正常的使用效果。

    PREFIX = "Convenience methods";
    // 当你有一个实例，并不知道它是否为null，因此需要使用if检查null值。
    // 下面这个方法，可以在第一个实例为null时，返回第二个实例参数。
    // 但如果两个都是null，则抛出空指针异常。
    // 所以这部分内容，推荐使用Optional.or来 替换 下面的用法。
    String nonNull = MoreObjects.firstNonNull(null, "Null");
    show(nonNull);
    // 替代方案，如果是一个不存在的对象，则有一个替代者，而这个替代者不能是null
    Optional<Integer> one = Optional.of(1);
    Optional or = one.or(Optional.of(2));
    show(or);
    // 另外，有一些分辨null strings 和 empty strings的方法
    // 将empty转为null
    show(Strings.emptyToNull(""));
    // 判断是否为null或empty
    show(Strings.isNullOrEmpty("Non-null and non-empty"));
    // 将null转为empty，也就是""
    show(Strings.nullToEmpty(null));
  }
}