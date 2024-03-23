package org.example;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    int size;
    LinkedList() {}
    LinkedList(T ... data) {
        head = new Node<>(data[0]);
        Node<T> cur = head;
        for (int i = 1; i < data.length; i++) {
            cur.next = new Node<T>(data[i]);
            cur = cur.next;
        }
    }
    public void add (T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<>(data);
        }
        size++;
    }

    public void add (int index, T data) {
        Node<T> node = new Node<>(data);
        Node<T> cur = head;
        if (index == 0) { // вставка на 0 позицию
            head = node;
            head.next = cur;
        } else { // вставка на произвольную позицию
            int counter = 0;
            while (index > counter + 1 && cur.next != null) { // остановка перед нужным "индексом", куда хотим добавлять
                cur = cur.next;
                counter++;
            }
            if (cur.next == null) { // сработает, при попытке добавить на несуществующую позицию
                throw new IndexOutOfBoundsException();
            }
            node.next = cur.next;
            cur.next = node;
        }
        size++;
    }

    public T findByIndex (int index) {
        int counter = 0;
        Node<T> cur = head;
        while (index != counter && cur != null) {
            cur = cur.next;
            counter++;
        }
        if (cur == null) throw new IndexOutOfBoundsException(); // проброс исключения в случае ошибки при вводе индекса
        return cur.data;
    }
    public int findByValue (T data) {
        Node<T> cur = head;
        int counter = 0;
        while (cur != null) {
            if (cur.data == data) {
                return counter;
            }
            cur = cur.next;
            counter++;
        }
        return -1;
    }
    public int size() {
        return this.size;
    }
    public void clear () {
        head = null;
    }
    public void remove (int index) {
        if (index == 0) {
            head = head.next;
        } else {
            int counter = 0;
            Node<T> cur = head;
            while (index - 1 != counter && cur != null) { // остановка перед удаляемым элементом
                cur = cur.next;
                counter++;
            }
            if (cur == null) throw new IndexOutOfBoundsException();
            cur.next = cur.next.next;
        }
        size--;
    }
    public String toString () {
        String str = "";
        Node<T> cur = head;
        while (cur != null) {
            str += cur.data + ", ";
            cur = cur.next;
        }
        return  "[" + str.substring(0, str.length()-2) + "]";
    }
}
