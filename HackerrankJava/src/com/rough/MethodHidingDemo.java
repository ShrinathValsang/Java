package com.rough;

class Demo {
    public static void method1() {
        System.out.println("Method1 of the com.rough.Demo");
    }

    public void method2() {
        System.out.println("Method2 of the com.rough.Demo");
    }
}

//child class
class Sample extends Demo {
    public static void method1() {
        System.out.println("Method1 of the com.rough.Sample");
    }

    public void method2() {
        System.out.println("Method2 of the com.rough.Sample");
    }

}

public class MethodHidingDemo {

    public static void main(String args[]) {
        Demo d1 = new Demo();
        //d2 is reference variable of class com.rough.Demo that points to object of class com.rough.Sample
        Demo d2 = new Sample();

        // method calling with reference (method hiding)
        d1.method1();
        d2.method1();

        // method calling with object (method overriding)
        d1.method2();
        d2.method2();
    }
}