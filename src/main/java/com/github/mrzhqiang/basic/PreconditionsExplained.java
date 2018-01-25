package com.github.mrzhqiang.basic;

import com.github.mrzhqiang.data.Person;
import com.google.common.collect.Lists;
import java.util.List;

import static com.google.common.base.Preconditions.*;

/**
 * <a href="https://github.com/google/guava/wiki/PreconditionsExplained">PreconditionsExplained</a>
 */
final class PreconditionsExplained {

  public static void main(String[] args) {
    /*
     * Test preconditions for your methods more easily.
     * */

    /*前置条件检测，同样是用来避免“null指针”，“非法参数”，以及“无效状态”的情况。*/
    /*以下顺序有所改变，需要重试的话，请从上面开始注释。*/
    // 4. 索引越界
    List<String> someList = Lists.newArrayList("001", "002", "003");
    // 位置的索引，起点不能小于0，不能大于终点，终点不能超过大小
    checkPositionIndexes(1, 4, someList.size());
    // 位置的索引，可以等于数组大小
    checkPositionIndex(4, someList.size());
    // 元素的索引，不能等于或大于数组的大小
    checkElementIndex(3, someList.size(), "Can greater than but");
    checkElementIndex(3, someList.size());
    // 3. 无效状态
    double random = Math.random() + 1;
    // greater than >
    // less than <
    checkState(random < 1, "random less than %s", 1);
    checkState(random < 1, random);
    checkState(random < 1);
    // 2. null指针
    Person personNotNull = Person.random(100);
    Person personNull = null;
    personNull = checkNotNull(personNull, "personNull is %s", personNull);
    personNull = checkNotNull(personNull, personNotNull);
    checkNotNull(personNull);
    // 1. 参数检测
    Person randomPerson = Person.random(30);
    Person emptyPerson = Person.empty();
    checkArgument(emptyPerson.equals(randomPerson), "randomPerson: %s, emptyPerson: %s",
        randomPerson, emptyPerson);
    checkArgument(randomPerson.equals(emptyPerson), "randomPerson not equals emptyPerson.");
    checkArgument(randomPerson.isEmpty());

    /*
     * 有前置条件的检测，对于代码健壮性而言，将会有很大的帮助。
     * 并且，很容易就跟踪到，是哪个参数，哪个对象，哪个位置出了问题。
     * */
  }
}
