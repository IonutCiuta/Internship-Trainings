package exercises;

/**
 * Created by iciuta on 7/14/2016.
 */
public class ExceptionsExercisesMain {

    private static void throwOutOfMemory() throws OutOfMemoryError {
        System.out.println("I'm about to run out of memory!");
        throw new OutOfMemoryError("OUT OF MEMORY");
    }

    private static void throwStackOverflow() throws StackOverflowError {
        System.out.println("I'm about to overflow my stack!");
        throw new StackOverflowError("STACK OVERFLOW");
    }

    private static void testErrors() {
        try {
            throwOutOfMemory();
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }

        try {
            throwStackOverflow();
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }

        System.out.println("It looks like these errors can't stop me! huehuehue");
    }

    private static void testCalculator() {
        Calculator c = new Calculator();
        try {
            System.out.println("1 + 3 = " + c.add(1, 3));
            System.out.println("10000 + 3 = " + c.add(10000, 3));
            System.out.println("MAX_VALUE + 0 = " + c.add(Integer.MAX_VALUE, 0));
            System.out.println("4 / 2 = " + c.divide(4, 2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("MAX_VALUE + 100 = " + c.add(Integer.MAX_VALUE, 100));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace(); //messes up the console
        }

        try {
            System.out.println("MIN_VALUE - 100 = " + c.add(Integer.MIN_VALUE, -100));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace(); //messes up the console
        }
    }

    private static int finallyBeatsReturn() {
        try {
            return 1;
        } catch (Exception e) {
            System.out.println("I'm redundant!");
        } finally {
            return 100;
        }
    }

    private static void testFinallyBeatsReturn() {
        System.out.println("Method should return 1 but, it will probablu return. . . " + finallyBeatsReturn());
    }

    public static void main(String[] args) {
        testErrors();
        System.out.println();

        testCalculator();
        System.out.println();

        testFinallyBeatsReturn();
        System.out.println();
    }
}
