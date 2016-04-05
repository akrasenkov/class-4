package com.company;

public abstract class TestAbstract {

    private String stringTest;

    public abstract String returnPartString(int partStart);

    @Override
    public String toString() {
        return "TestAbstract{" +
                "stringTest='" + stringTest + '\'' +
                '}';
    }
}
