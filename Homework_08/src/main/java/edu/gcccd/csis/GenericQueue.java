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
            System.out.println("We empty");
            return null;
        }
        else {


            return ;
        }

    }

    public void enqueue(T value) {
        list.add(value);
    }

    // current length of the queue
    public int length() {
        return list.size();
    }




    public static void main(String[] args) {
        GenericQueue<Integer> Que = new GenericQueue<>(10);

        Que.enqueue(5);
        Que.enqueue(4);
        Que.enqueue(3);

        System.out.println(Que.dequeue());
        System.out.println(Que.dequeue());
        System.out.println(Que.dequeue());
    }

}
