package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    private DoublyLinkedList doubleList;
    @BeforeEach
    void setUp () {
        doubleList = new DoublyLinkedList();
    }
    @Test
    void add () {
        doubleList.add(1);
        Assertions.assertEquals(1,doubleList.head.data);
    }
    @Test
    void add_checkEnd () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(3,doubleList.end.data);
    }
    @Test
    void add_onZeroIndex () {
        doubleList.add(1);
        doubleList.add(0,2);
        Assertions.assertEquals(1,doubleList.end.data);
        Assertions.assertEquals(2,doubleList.head.data);
    }
    @Test
    void add_onFirstHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.add(2,7);
        Assertions.assertEquals(7,doubleList.head.next.next.data);
        Assertions.assertEquals(6,doubleList.end.data);
    }
    @Test
    void add_onSecondHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.add(3,7);
        Assertions.assertEquals(7,doubleList.end.prev.prev.prev.data);
        Assertions.assertEquals(6,doubleList.end.data);
    }
    @Test
    void add_onNonExistentPosition () {
        doubleList.add(1);
        try {
            doubleList.add(1,2);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void clear () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.clear();
        try {
            Assertions.assertEquals(2,doubleList.end.prev.data);
        } catch (NullPointerException exception) {}
    }
    @Test
    void toString_ () {
        doubleList.add(1);
        doubleList.add(2);
        Assertions.assertEquals("[1, 2]", doubleList.toString());
    }
    @Test
    void remove_onFirstPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.remove(0);
        Assertions.assertEquals(2,doubleList.head.data);
    }
    @Test
    void remove_onSecondHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.remove(2);
        Assertions.assertEquals(2,doubleList.end.prev.prev.data);
    }
    @Test
    void remove_onFirstHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.remove(2);
        Assertions.assertEquals(4,doubleList.head.next.next.data);
    }
    @Test
    void remove_onLastPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.remove(2);
        Assertions.assertEquals(2,doubleList.end.data);
    }
    @Test
    void remove_onNonExistentPosition () {
        doubleList.add(1);
        try {
            doubleList.remove(1);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void DoubleDataList_constructor () {
        DoublyLinkedList testList = new DoublyLinkedList(1,2,3);
        Assertions.assertEquals(1,testList.head.data);
        Assertions.assertEquals(2,testList.head.next.data);
        Assertions.assertEquals(3,testList.end.data);
    }
    @Test
    void findByIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(1,doubleList.findByIndex(0));
    }
    @Test
    void findByIndex_onFirstPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        Assertions.assertEquals(2,doubleList.findByIndex(1));
    }
    @Test
    void findByIndex_onSecondPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(2,doubleList.findByIndex(1));
    }
    @Test
    void findByIndex_onNonExistentPosition () {
        doubleList.add(1);
        try {
            doubleList.findByIndex(1);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void findByValue () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(0,doubleList.findByValue(1));
    }
    @Test
    void findByValue_noElement () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(-1,doubleList.findByValue(4));
    }
}
