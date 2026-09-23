package com.calsoft;

import java.util.List;

public final class MySingleton2 {

    private static MySingleton2 singleton;

    private MySingleton2() {}

    // Double-Checked Locking Singleton
    public static MySingleton2 getInstance3() {
        if (singleton == null) {
            synchronized (MySingleton2.class) {
                if (singleton == null) {
                    singleton = new MySingleton2();
                    // due to semantics of the programming language, the compiler has the right modify the shared
                    // variable before the first thread's initialization is completed
                }
            }
        }

        return singleton;
    }

}
