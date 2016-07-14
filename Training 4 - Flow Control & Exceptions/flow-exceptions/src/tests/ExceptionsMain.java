package tests;

import java.io.IOException;

/**
 * Created by iciuta on 7/14/2016.
 */
public class ExceptionsMain {
    private static void throwFromFinally() throws UnsupportedOperationException {
        try {
            System.out.println("I tried. . .");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("But I failed. . . ");
            throw new UnsupportedOperationException(". . .die");
        } finally {
            /*this should be the only exception caught in main*/
            System.out.println("So finally I. . .");
            throw new UnsupportedOperationException(". . . eat cookies");
        }
    }

    private static int returnFromFinally(int value) {
        try {
            System.out.println("Return from try " + value);
            return value;
        } finally {
            int newValue = value * 3 / 2;
            System.out.println("Return from finally " + newValue);
            return newValue;
        }
    }

    private static int maskExceptionWithReturnFromFinally(int value) throws Exception{
        try {
            System.out.println("Return from try " + value);
            throw new Exception("Oopsie. . .");
        } finally {
            int newValue = value * 3 / 2;
            System.out.println("(Should mask exception) Return from finally " + newValue);
            return newValue;
        }
    }

    private static void textTryCatchWithResources() {
        try (ClosableImpl obj = new ClosableImpl()) {
            obj.doStuff();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
           throwFromFinally();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Bye bye. . .");
        }

        System.out.println();

        /***********************************************************/

        System.out.println("And the winner is: " + returnFromFinally(110));
        System.out.println();

        /***********************************************************/

        try {
            System.out.println("And the winner is: " + maskExceptionWithReturnFromFinally(9));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        /***********************************************************/

        textTryCatchWithResources();

        /***********************************************************/
    }
}
