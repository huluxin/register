package com.IsoftStone.core.generics;

import com.IsoftStone.core.net.mindview.util.BasicGenerator;
import com.IsoftStone.core.net.mindview.util.Generator;

/**
 * Created by Ivan Wang on 2014/7/17.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.print(gen.next());
        }
    }
}
