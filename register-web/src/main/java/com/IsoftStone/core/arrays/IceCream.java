package com.IsoftStone.core.arrays;

import java.util.Arrays;
import java.util.Random;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * Returning arrays from methods.
 * Created by RunGen<润根> on 2014/8/26.
 */
public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    /**
     * 每次随机获取味道，保证不重复
     *
     * @param n 基数
     * @return
     */
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        // print(Arrays.toString(picked));
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavorSet(3)));
    }
}
