package org.example;

public class ArrayList<T> {
    T [] arr;
    int size;
    int capacity;
    ArrayList () {
        capacity = 10;
        arr = (T[]) new Object[capacity];
    }
    private void boostCapacity () {
        capacity = capacity * 2;
        T [] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public void add (T data) {
        if (size + 1 > capacity) {
            boostCapacity();
        }
        arr[size] = data;
        size++;
    }
    public void add (int index, T data) {
        if (size + 1 > capacity) {
            boostCapacity();
        }
        arr[size + 1] = data;
        size++;
        for (int i = 0; i < size - index; i++) {
            T tmp = arr[size - i];
            arr[size - i] = arr[size - i - 1];
            arr[size - i - 1] = tmp;
        }
    }
    public void clear() {
        arr = null;
        size = 0;
    }
    public T find(int index) {
        return arr[index];
    }
    public void remove (int index) {
        if (size < capacity/2) {
            T[] newArr = (T[]) new Object [capacity / 2];
            for (int i = 0; i < size; i++) {
                if (index == i) continue;
                newArr[i] = arr[i];
            }
        } else {
            for (int i = index; i < size; i++) {
                arr[i] = arr[i+1];
            }
        }
    }
    public void print() {
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
