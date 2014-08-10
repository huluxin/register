//: net/mindview/util/Sets.java
package com.IsoftStone.core.net.mindview.util;
import java.util.*;

public class Sets {
    //返回Set ，它将2个参数合并在一起
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.addAll(b);
    return result;
  }
    //返回的Set 只包含2个参数共有部分
  public static <T>
  Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }	
  // Subtract subset from superset: 从 superset 中移除 subset 包含的元素
  public static <T> Set<T>
  difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }
  // Reflexive--everything not in the intersection: 返回的set 包含除了交集之外的所有元素
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
} ///:~
