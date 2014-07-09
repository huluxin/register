package com.IsoftStone.core.generics;

import com.IsoftStone.core.net.mindview.util.FiveTuple;
import com.IsoftStone.core.net.mindview.util.FourTuple;
import com.IsoftStone.core.net.mindview.util.ThreeTuple;
import com.IsoftStone.core.net.mindview.util.TwoTuple;

/**
 * 元祖类库（tuple）
 * 它是将一组对象直接打包存储于其中的一个单一对象
 * Created by Ivan Wang on 2014/7/10.
 */
class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(
                new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return
                new FourTuple<Vehicle, Amphibian, String, Integer>(
                        new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new
                FiveTuple<Vehicle, Amphibian, String, Integer, Double>(
                new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }
    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
