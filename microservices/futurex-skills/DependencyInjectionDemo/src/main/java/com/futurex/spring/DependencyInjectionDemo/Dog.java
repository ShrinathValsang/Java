package com.futurex.spring.DependencyInjectionDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dog implements Animal {

    @Override
    public void speak() {
        System.out.println("bhow bhow!");
    }
}
