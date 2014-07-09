package com.IsoftStone.core.typeinfo;

import com.IsoftStone.core.typeinfo.interfacea.A;
import com.IsoftStone.core.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * 通过反射，即使是private 方法，如果知道方法名，
 * 可以通过 setAccessible(true) 来运行方法
 * Created by Ivan Wang on 2014/7/9.
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
       /* if(a instanceof C) {
            C c = (C) a;
            c.g();
        }*/
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName)
            throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
