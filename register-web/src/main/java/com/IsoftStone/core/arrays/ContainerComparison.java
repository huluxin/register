package com.IsoftStone.core.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * Created by Ivan Wang on 2014/8/26.
 */
class BeryliumSpace {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Shere " + id;
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BeryliumSpace[] spheres = new BeryliumSpace[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BeryliumSpace();
        }
        print(Arrays.toString(spheres));
        print(spheres[4]);

        List<BeryliumSpace> sphereList = new ArrayList<BeryliumSpace>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BeryliumSpace());
        }
        print(sphereList);
        print(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        print(Arrays.toString(integers));
        print(integers[4]);

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        print(intList);
        print(intList.get(4));
    }
}
