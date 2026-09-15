package com.calsoft;

import java.util.List;

public enum MyEnumSingleton {

    INSTANCE;

    public static void main(String[] args) {
        new SingletonBuilder("Rohan Informatics").age(2000).build();
        MyEnumSingleton.getInstance().getInfo();
    }

    private static MyEnumSingleton getInstance() {
        return INSTANCE;
    }

    public void getInfo() {
        System.out.println("Org Est: " + est + ", name: " + orgname);
    }

    private int est;
    private String orgname;

    private void build(SingletonBuilder builder) {
        this.est = builder.est;
        this.orgname = builder.orgname;
    }

    public static class SingletonBuilder {
        private int est;
        private String orgname;

        public SingletonBuilder() {}
        // public SingletonBuilder(int est) { this.est = est; }
        public SingletonBuilder(String orgname) { this.orgname = orgname; }
        // public SingletonBuilder(int est, String orgname) { this.est = est; this.orgname = orgname; }

        public SingletonBuilder age(int age) {
            this.est = age;
            return this;
        }

        public void build() {
            MyEnumSingleton.INSTANCE.build(this);
        }

    }
}
