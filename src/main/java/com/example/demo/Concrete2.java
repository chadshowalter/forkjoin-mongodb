package com.example.demo;

import java.util.StringJoiner;

public class Concrete2 extends AbstractBase{
    private String s;

    public Concrete2(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Concrete2.class.getSimpleName() + "[", "]")
                .add("s='" + s + "'")
                .toString();
    }
}
