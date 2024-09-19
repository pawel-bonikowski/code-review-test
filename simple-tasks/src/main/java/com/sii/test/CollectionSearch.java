package com.sii.test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

public class CollectionSearch {

    public static final int DATA_SIZE = 100;

    public static void main(String[] args) {
        TestObjectContainer container = new TestObjectContainer();
        measure(() -> initData(container, DATA_SIZE), "Data initialization took:");
        Random random = new Random();
        measure(() -> runSearch(random, container), "Search took:");
    }

    static class TestObjectContainer {

        private final Collection<TestObject> list = new ArrayList<>();

        void addToContainer(TestObject testObject) {
            list.add(testObject);
        }

        TestObject find(int index) {
            return list.stream().filter(i -> i.id() == index)
                    .findFirst().orElse(null);
        }

    }

    private static void runSearch(Random random, TestObjectContainer dataContainer) {
        for (int j = 0; j < 100; j++) {
            int searchableId = random.nextInt(DATA_SIZE-1);
            TestObject testObject = dataContainer.find(searchableId);
            System.out.println("Found: " + testObject);
        }
    }

    private static void initData(TestObjectContainer container, int size) {
        IntStream.range(1, size)
                .mapToObj(TestObject::new)
                .forEach(container::addToContainer);
    }

    private static void measure(Runnable action, String message) {
        long startTime = System.currentTimeMillis();
        action.run();
        long endTime = System.currentTimeMillis();
        System.out.println(message + (endTime - startTime) + "ms");
    }

    record TestObject(int id) implements Comparable<TestObject> {

        @Override
        public int compareTo(@NotNull CollectionSearch.TestObject o) {
            return o.id() - this.id();
        }
    }

}
