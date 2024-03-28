package org.example;
import java.util.Comparator;


public class MyComparable implements Comparable<MyComparable> {
    private final int value;

    public MyComparable(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyComparable otherObject) {
        return this.value - otherObject.value;
    }

    public int getValue() {
        return value;
    }
}


