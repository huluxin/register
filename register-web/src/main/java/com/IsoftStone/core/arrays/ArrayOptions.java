package com.IsoftStone.core.arrays;

import java.util.Arrays;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * Initialization & re-assignment of arrays.<数组的初始化></>
 * Created by RunGen on 2014/8/26.
 */
public class ArrayOptions {
    public static void main(String[] args) {
        // Arrays of objects:
        BeryliumSpace[] a;  // Local uninitialized variable
        BeryliumSpace[] b = new BeryliumSpace[5];
        print("b: " + Arrays.toString(b));

        BeryliumSpace[] c = new BeryliumSpace[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null)    // Can test for null reference
                c[i] = new BeryliumSpace();
        }
        BeryliumSpace[] d = {new BeryliumSpace(), new BeryliumSpace(), new BeryliumSpace()};
        a = new BeryliumSpace[]{new BeryliumSpace(), new BeryliumSpace()};

        // (Trailing comma is optional in both cases)
        print("a.length = " + a.length);
        print("b.length = " + b.length);
        print("c.length = " + c.length);
        print("d.length = " + d.length);

        a = d;
        print("a.length = " + a.length);

        // Arrays of primitives:
        int[] e;    // Null reference
        int[] f = new int[5];
        print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        print("f.length = " + f.length);
        print("g.length = " + g.length);
        print("h.length = " + h.length);
        e = h;
        print("e.length = " + e.length);
        e = new int[]{1, 2};
        print("e.length = " + e.length);
    }
}
