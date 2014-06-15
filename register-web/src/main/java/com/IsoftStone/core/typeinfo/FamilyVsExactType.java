package com.IsoftStone.core.typeinfo;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * Created by Bachelor Wang on 2014/6/15.
 */
class Base{}

class Derived extends Base{};

public class FamilyVsExactType {
    static void test(Object x) {
        print("Testing x of type " + x.getClass());
        print("x instanceof Base " + (x instanceof Base));
        print("x instanceof Derived "+ (x instanceof Derived));
        print("Base.isInstance(x) "+ Base.class.isInstance(x));
        print("Derived.isInstance(x) " +
                Derived.class.isInstance(x));
        print("x.getClass() == Base.class " +
                (x.getClass() == Base.class));
        print("x.getClass() == Derived.class " +
                (x.getClass() == Derived.class));
        print("x.getClass().equals(Base.class)) "+
                (x.getClass().equals(Base.class)));
        print("x.getClass().equals(Derived.class)) " +
                (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
