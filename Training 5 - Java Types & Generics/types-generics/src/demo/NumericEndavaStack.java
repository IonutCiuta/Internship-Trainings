package demo;

/**
 * Created by iciuta on 7/15/2016.
 */
public class NumericEndavaStack<N extends Number> implements Stack<N>{
    N head;
    NumericEndavaStack<N> tail;

    private NumericEndavaStack() {

    }

    public NumericEndavaStack(N item) {
        this.head = item;
    }

    public NumericEndavaStack(N... items) {
        head = items[0];
        for(int i = 1; i < items.length; i++) {
            push(items[i]);
        }
    }

    public void push(N item) {
        if(tail == null) {
            tail = new NumericEndavaStack<>(head);
        } else {
            tail.push(head);
        }

        head = item;
    }

    public N pop() {
        N result = head;

        head = tail.head;
        tail = tail.tail;

        return result;
    }

    public int size() {
        int result = 1;

        if(tail != null) {
            result += tail.size();
        }

        return result;
    }

    public N head() {
        return head;
    }

    /*I used double to avoid all precision/value issue*/
    public double getMax() {
        if(tail == null) {
           return head.doubleValue();
        } else {
            return Math.max(head.doubleValue(), tail.getMax());
        }
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
