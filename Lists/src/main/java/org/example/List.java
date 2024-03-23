package org.example;

public interface List<T> {
    void add(T data);
    void add(int index, T data);
    void remove (int index);
    void clear();
    T findByIndex(int index);
    int findByValue(T data);
    String toString ();
}
