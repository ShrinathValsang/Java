package com.futurex.spring.DependencyInjectionDemo;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    @Override
    public void speak() {
        System.out.println("meow meow!");
    }
}
