package com.IsoftStone.core.typeinfo;

import com.IsoftStone.core.typeinfo.interfacea.A;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * 接口的实现为一个私有的内部类，仍然可以通过
 * 反射来运行私有的方法
 * Created by Ivan Wang on 2014/7/9.
 */
class InnerA {
    private static class C implements A {
        public void f() { print("public C.f()"); }
        public void g() { print("public C.g()"); }
        void u() { print("package C.u()"); }
        protected void v() { print("protected C.v()"); }
        private void w() { print("private C.w()"); }
    }
    public static A makeA() { return new C(); }
}

public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the private class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
