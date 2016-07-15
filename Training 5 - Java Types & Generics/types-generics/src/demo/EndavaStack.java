package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 7/15/2016.
 */
public class EndavaStack<T> implements Stack<T>{
    T head;
    EndavaStack<T> tail;

    private EndavaStack() {

    }

    public EndavaStack(T item) {
        this.head = item;
    }

    public EndavaStack(T... items) {
        head = items[0];
        for(int i = 1; i < items.length; i++) {
            push(items[i]);
        }
    }

    public void push(T item) {
        if(tail == null) {
            tail = new EndavaStack<>(head);
        } else {
            tail.push(head);
        }

        head = item;
    }

    public T pop() {
        T result = head;

        head = tail.head;
        tail = tail.tail;

        return result;
    }

    public T head() {
        return head;
    }

    public int size() {
        int result = 1;

        if(tail != null) {
            result += tail.size();
        }

        return result;
    }

    @Override
    public String toString() {
        if(tail == null) {
            return head.toString();
        } else {
            return head + " " + tail.toString();
        }
    }
}
