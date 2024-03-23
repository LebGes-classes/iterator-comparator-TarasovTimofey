package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    private LinkedList list;
    @BeforeEach
    void setUp () {
        list = new LinkedList();
    }
    @Test
    void add () {
        list.add(1);
        Assertions.assertEquals(1,list.head.data);
    }
    @Test
    void add_onZeroPosition () {
        list.add(1);
        list.add(2);
        list.add(0,3);
        Assertions.assertEquals(3,list.head.data);
        Assertions.assertEquals(1,list.head.next.data);
    }
    @Test
    void add_onRandomPosition () {
        list.add(1);
        list.add(2);
        list.add(1,3);
        Assertions.assertEquals(1,list.head.data);
        Assertions.assertEquals(3,list.head.next.data);
    }
    @Test
    void add_onNonExistentPosition () {
        list.add(1);
        list.add(2);
        try {
            list.add(2,3);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void findByIndex () {
        list.add(1);
        list.add(2);
        list.add(3);
        list.findByIndex(2);
        Assertions.assertEquals(3,list.head.next.next.data);
    }
    @Test
    void findByIndex_IndexOutOfBoundsException () {
        list.add(1);
        try {
            list.findByIndex(1);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void findByValue () {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(0,list.findByValue(1));
    }
    @Test
    void findByValue_noElement () {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(-1,list.findByValue(4));
    }
    @Test
    void clear () {
        list.add(1);
        list.clear();
        try {
            Assertions.assertEquals(1,list.head.data);
        } catch (NullPointerException exception) {}
    }
    @Test
    void DataList_constructor () {
        LinkedList testList = new LinkedList(1,2,3);
        Assertions.assertEquals(1,testList.head.data);
        Assertions.assertEquals(2,testList.head.next.data);
    }
    @Test
    void remove () {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        Assertions.assertNull(list.head.next.next);
    }
    @Test
    void remove_onZeroPosition () {
        list.add(1);
        list.remove(0);
        Assertions.assertNull(list.head);
    }
    @Test
    void toString_ () {
        list.add(1);
        list.add(2);
        Assertions.assertEquals("[1, 2]", list.toString());
    }
}
