package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {
    private int currentIndex;
    private final LinkedList<E> list;

    public MyIterator(LinkedList<E> list) {
        this.currentIndex = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext(){
        while(currentIndex < list.size()) {
            E next = next();
            if (next != null) {
                return true;
            }
        }
        return false;
    }
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.findByIndex(currentIndex++);
    }
    @Override
    public void remove() {
        list.remove(currentIndex);
    }
}
