package com.calsoft;

import java.util.ArrayList;
import java.util.List;

public final class MySingleton {

    private int id;
    private List<String> list;

    // 1. Pre-initialized Singleton /
    // private static final MySingleton singleton = new MySingleton(10, new ArrayList<>());
    // public static MySingleton getInstance() {
    //     return singleton;
    // }

    private static MySingleton singleton;

    private MySingleton(final int myId, final List<String> list) {
        this.id = myId;
        this.list = List.copyOf(list);
    }

    public int getId() {
        return id;
    }

    public List<String> getList() {
        return list;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    // 2. Minimal singleton
    public static MySingleton getInstance() {
        List<String> myList = List.of("m1", "m2", "m3");
        singleton = new MySingleton(10, myList);
        return singleton;
    }

    // 3. Lazy-loading Singleton
    public static MySingleton getInstance1() {
        if (singleton == null) {
            List<String> myList = List.of("m1", "m2", "m3");
            singleton = new MySingleton(10, myList); // susceptible in multithreaded environment
        }
        return singleton;
    }

    // 4. Synchronized Singleton
    public static MySingleton getInstance2() {
        if (singleton == null) {
            synchronized (MySingleton.class) {
                List<String> myList = List.of("m1", "m2", "m3");
                singleton = new MySingleton(10, myList);
            }
        }

        return singleton;
    }

    // 5. Double-Checked Locking Singleton
    public static MySingleton getInstance3() {
        if (singleton == null) {
            synchronized (MySingleton.class) {
                if (singleton == null) {
                    List<String> myList = List.of("m1", "m2", "m3");
                    singleton = new MySingleton(20, myList);
                    // due to semantics of the programming language, the compiler has the right modify the shared
                    // variable before the first thread's initialization is completed

                }
            }
        }

        return singleton;
    }

}
