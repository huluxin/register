package com.IsoftStone.core.generics;

/**
 * Created by Ivan Wang on 2014/7/17.
 */
public class CountedObject {

    private static long counter = 0;
    private final long id = counter++;
    public long id() { return id; }
    public String toString() { return "CountedObject " + id;}
}
