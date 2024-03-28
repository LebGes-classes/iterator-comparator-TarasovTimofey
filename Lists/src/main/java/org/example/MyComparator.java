package org.example;

import java.util.Comparator;

public class MyComparator implements Comparator<MyComparable> {
    @Override
    public int compare(MyComparable obj1, MyComparable obj2) {
        return obj1.getValue() - obj2.getValue();
    }
}
