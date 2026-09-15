package com.bnymellon;

import java.util.Objects;

public class Person {

    private String name;
    private int age;
    private String passportNumber;

    public Person(String name, int age, String passportNumber) {
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
    }


    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassportNumber() { return passportNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(passportNumber, person.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passportNumber);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age +
                ", passportNumber='" + passportNumber + "'}";
    }
}
