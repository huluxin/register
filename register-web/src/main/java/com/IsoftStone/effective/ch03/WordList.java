package com.IsoftStone.effective.ch03;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2014/8/1.
 */
public class WordList {
    public static void main(String[] args) {
        Set s = new TreeSet();
        s.addAll(Arrays.asList(args));
        System.out.println(s);
    }
}
