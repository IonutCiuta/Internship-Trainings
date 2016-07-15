package generics;

/**
 * Created by iciuta on 7/15/2016.
 */
public interface Stack<T> {
    T head();
    void push(T item);
    T pop();
    int size();
}
