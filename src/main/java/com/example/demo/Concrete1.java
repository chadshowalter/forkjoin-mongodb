package com.example.demo;

import java.util.StringJoiner;

public class Concrete1 extends AbstractBase{
    private int a;

    public Concrete1(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Concrete1.class.getSimpleName() + "[", "]")
                .add("a=" + a)
                .toString();
    }
}
