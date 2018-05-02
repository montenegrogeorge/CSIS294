package edu.gcccd.csis;

import java.util.ArrayList;
import java.lang.String;
import java.util.EmptyStackException;

public class GenericQueue <T> {

    private ArrayList<T> list;

    public GenericQueue() {
        this(10);
    }

    public GenericQueue(int size) {
        int initCapacity =  size > 0 ? size : 10;
        list = new ArrayList<T>(initCapacity);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            T node = list.get(0);
            list.remove(0);
            return node;
        }
    }

    public void enqueue(T value) {
        list.add(value);
    }

    // current length of the queue
    public int length() {
        return list.size();
    }
}
