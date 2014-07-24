package com.IsoftStone.effective.ch02;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 06 消除过期的对象引用
 * 下面代码隐藏一个‘内存泄漏’问题，因为如果一个桟先是增长，然后再收缩，
 * 那么，从桟中弹出来的对象不会被当作垃圾回收，即使使用桟的程序不在引用
 * 这些对象，它们也不会被回收。桟内部维护着对这些对象的过期引用。
 * 过期引用，是指永远也不会在被解除的引用。
 * Created by Administrator on 2014/7/24.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
