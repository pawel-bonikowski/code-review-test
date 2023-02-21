package com.sii.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Collection {
    public static void main(String... varargs) {
        Test test1 = new Test("Test1");
        Test test2 = new Test("Test2");
        Test test3 = new Test("Test3");

        HashSet<Test> set = new HashSet<>(Arrays.asList(test1, test2, test3));
        set.forEach(i -> i.name = "Test4");
        set.remove(test1);

        System.out.println("Set size = " + set.size());
    }
}

class Test {

    public String name;
    public Test(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
