package com.calsoft;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public final class  MyImmutable {

    private final int id;
    private final List<String> list;

    private MyImmutable(final int myId, final List<String> list) {
        this.id = myId;
        this.list = List.copyOf(list);
    }


    public int getId() {
        return id;
    }

    public List<String> getList() {
        return list;
    }


}

interface A {
    Optional<Integer> o = Optional.empty();
    default void hello() { System.out.println("Hello from A"); }
}

interface B {
    default void hello() { System.out.println("Hello from B"); }
}

class MyClass implements A, B {
    @Override
    public void hello() {
        // Resolve ambiguity explicitly
        A.super.hello();  // or B.super.hello()
    }
}

interface Payment {
    default void processCreditCard() {
        validateTransaction();
        System.out.println("Processing credit card payment...");
    }

    default void processPayPal() {
        validateTransaction();
        System.out.println("Processing PayPal payment...");
    }

    // Private helper method - Cannot be accessed outside
    private void validateTransaction() {
        System.out.println("Validating transaction...");
    }
}