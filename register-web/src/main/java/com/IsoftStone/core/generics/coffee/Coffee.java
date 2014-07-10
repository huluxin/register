package com.IsoftStone.core.generics.coffee;

/**
 * Created by Ivan Wang on 2014/7/10.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
