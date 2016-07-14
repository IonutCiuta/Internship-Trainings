package exercises;

import java.util.List;

/**
 * Created by iciuta on 7/14/2016.
 */
public class Calculator {
    private final long REF_MAX = Integer.MAX_VALUE;
    private final long REF_MIN = Integer.MIN_VALUE;

    public Integer add(Integer a, Integer b) throws OverflowException, UnderflowException{
        long actualResult = (long)a + (long)b;

        if(actualResult > REF_MAX)
            throw new OverflowException();

        if(actualResult < REF_MIN)
            throw new UnderflowException();

        return (int)actualResult;
    }

    public Integer divide(Integer a, Integer b) throws OverflowException, UnderflowException {
        long actualResult = (long)a / (long)b;

        if(actualResult > REF_MAX)
            throw new OverflowException();

        if(actualResult < REF_MIN)
            throw new UnderflowException();

        return (int)actualResult;
    }

    public Integer average(List<Integer> input) throws OverflowException, UnderflowException {
        long actualResult = 0;
        for(Integer i : input) {
            actualResult += i;
        }

        actualResult /= input.size();

        if(actualResult > REF_MAX)
            throw new OverflowException();

        if(actualResult < REF_MIN)
            throw new UnderflowException();

        return (int)actualResult;
    }

    private class OverflowException extends Exception {
        public OverflowException() {
            super("OVERFLOW");
        }
    }

    private class UnderflowException extends Exception {
        public UnderflowException() {
            super("UNDERFLOW");
        }
    }
}
