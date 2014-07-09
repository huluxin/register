package com.IsoftStone.core.typeinfo.packageaccess;

import com.IsoftStone.core.typeinfo.interfacea.A;

import static com.IsoftStone.core.net.mindview.util.Print.print;

/**
 * Created by Ivan Wang on 2014/7/9.
 */
class C implements A {

    @Override
    public void f() {
        print("public C.f()");
    }
    public void g() { print("public C.g()"); }
    void u() { print("package C.u()"); }
    protected void v() { print("protected C.v()"); }
    private void w() { print("private C.w()"); }
}
public class HiddenC {
    public static A makeA(){
        return new C();
    }
}
