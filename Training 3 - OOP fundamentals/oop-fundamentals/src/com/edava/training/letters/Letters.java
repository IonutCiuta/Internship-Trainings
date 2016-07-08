package com.edava.training.letters;

/**
 * Created by iciuta on 7/8/2016.
 */
class A {
    public void f() {
        System.out.println("a.f()");
    }

    public void f(int p1, int p2) {
        System.out.println("a.f(" + p1 + ", " + p2 + ")");
    }
}

class B extends A {
    @Override
    public void f() {
        System.out.println("b.f()");
    }

    @Override
    public void f(int p1, int p2) {
        System.out.println("b.f(" + p1 + ", " + p2 + ")");
    }
}

class C extends B {
    @Override
    public void f() {
        System.out.println("c.f()");
    }
}

public class Letters {
    public static void main(String[] args) {
        A a = new B(); a.f(); //should print B
        B b = new C(); b.f(); //should print C
        A c = new C(); c.f(); //should print C

        A aa = new B(); aa.f(1, 2);
    }
}


