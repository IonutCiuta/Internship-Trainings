package tests;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by iciuta on 7/14/2016.
 */
public class ClosableImpl implements Closeable {
    public void doStuff() {
        System.out.println("I'm opened!");
    }

    @Override
    public void close() throws IOException {
        System.out.println("I'm closed");
    }
}
