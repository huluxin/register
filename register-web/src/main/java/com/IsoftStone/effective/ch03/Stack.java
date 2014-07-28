package com.IsoftStone.effective.ch03;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * clone 方法的使用
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;

    public Stack(int intialCapactity) {
        this.elements = new Object[intialCapactity];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    protected Object clone() throws CloneNotSupportedException {
        Stack result = (Stack) super.clone();
        result.elements = (Object[])elements.clone();
        return result;
    }

    public void ensureCapacity() {
        if (elements.length == size) {
            Object oldElements[] = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack(0);
        for (int i = 0; i < args.length; i++)
            s.push(args[i]);

        Stack s2 = null;
        try {
            s2 = (Stack) s.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Assertion failure");  // Can't happen
        }

        for (int i = 0; i < args.length; i++)
            System.out.print(s.pop() + " ");
        System.out.println();

        for (int i = 0; i < args.length; i++)
            System.out.print(s2.pop() + " ");
        System.out.println();
    }
}
