package com.IsoftStone.core.typeinfo;

import com.IsoftStone.core.typeinfo.interfacea.A;

/**
 * Created by Ivan Wang on 2014/7/9.
            */
class B implements A {
        public void f() {}
        public void g() {}
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        //a.g(); Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b = (B)a;
            b.g();
        }
    }
}
