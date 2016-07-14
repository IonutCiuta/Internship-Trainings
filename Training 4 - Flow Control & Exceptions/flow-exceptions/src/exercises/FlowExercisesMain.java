package exercises;

import java.util.Arrays;

/**
 * Created by iciuta on 7/14/2016.
 */
public class FlowExercisesMain {
    private static final String EMPTY_STRING = "";

    /**Exercise 1**/
    private static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }

    private static void testMonkeyTrouble() {
        System.out.print("Do we have monkey trouble? " + (monkeyTrouble(true, true) ? "yes!" : "no.") + "\n");
        System.out.print("Do we have monkey trouble? " + (monkeyTrouble(false, false) ? "yes!" : "no.") + "\n");
        System.out.print("Do we have monkey trouble? " + (monkeyTrouble(true, false) ? "yes!" : "no.") + "\n");
    }

    /**Exercise 2**/
    private static boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour > 20 || hour < 7);
    }

    private static void testParrotTrouble() {
        System.out.print("Do we have parrot trouble? " + (parrotTrouble(true, 21) ? "yes!" : "no.") + "\n");
        System.out.print("Do we have parrot trouble? " + (parrotTrouble(false, 23) ? "yes!" : "no.") + "\n");
        System.out.print("Do we have parrot trouble? " + (parrotTrouble(true, 6) ? "yes!" : "no.") + "\n");
        System.out.print("Do we have parrot trouble? " + (parrotTrouble(true, 15) ? "yes!" : "no.") + "\n");
    }

    /**Exercise 3**/
    private static boolean posNeg(int a, int b, boolean negative) {
        if(negative) {
            return (a < 0) && (b < 0);
        } else {
            return ((a < 0) && (b > 0)) || ((a > 0) && (b < 0));
        }
    }

    private static void testPosNeg() {
        System.out.print("(1, 2, false) -> " + posNeg(1, 2, false) + "\n");
        System.out.print("(-2, 3, false) -> " + posNeg(-2, 3, false) + "\n");
        System.out.print("(-3, -2, true) -> " + posNeg(-3, -2, true) + "\n");
        System.out.print("(-1, -1, false) -> " + posNeg(-1, -1, false) + "\n");
        System.out.print("(-1, -1, false) -> " + posNeg(-1, -1, false) + "\n");
    }

    /**Exercise 4**/
    private static String backAround(String input) throws Exception{
        if(input.length() < 2)
            throw new Exception("String \"" + input + "\" is too short. Must have at least 2 chars.");

        char lastChar = input.charAt(input.length() - 1);
        return  lastChar + input + lastChar;
    }

    private static void testBackAround() {
        try {
            System.out.println(backAround("dog"));
            System.out.println(backAround("hi"));
            System.out.println(backAround("I"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**Exercise 5**/
    private static String everyNth(String input, int n) throws Exception{
        if(input.equals(EMPTY_STRING)) {
            throw new Exception("Input is empty!");
        }

        if(n < 1) {
            throw new Exception("N was " + n + ". Should be 1 or more!");
        }

        char[] inputChars = input.toCharArray();
        String result = EMPTY_STRING + inputChars[0];

        for(int i = n-1; i < input.length(); i += n) {
            result += inputChars[i];
        }

        return result;
    }

    private static void testEveryNth() {
        try {
            System.out.println("test, 0 -> " + everyNth("test", 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\"\", 100 -> " + everyNth(EMPTY_STRING, 100));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("knowledge is power, 2 -> " + everyNth("knowledge is power", 2) );
            System.out.println("testing my testing method developed for this test which is testing me, 3 -> " +
                    everyNth("testing my testing method developed for this test which is testing me", 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean scoresIncreasing(int[] input) throws Exception{
        if(input.length < 2) {
            throw new Exception("Array length should be at least 2.");
        }

        boolean result = true;
        for(int i = 1; i < input.length; i++) {
            if(input[i] < input[i-1]) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static void testScoresIncreasing() {
        int[] input1, input2, input3, input4;

        input1 = new int[5];
        for(int i = 0; i < input1.length; i++) {
            input1[i] = 10 * i + i;
        }

        input2 = new int[4];
        for(int i = 0; i < input2.length; i++) {
            input2[i] = 44;
        }

        input3 = new int[9];
        for(int i = 0; i < input3.length - 2; i++) {
            input3[i] = i;
        }
        input3[7] = -100;
        input3[8] = 477;

        input4 = new int[1];

        try {
            System.out.println(Arrays.toString(input1) + " -> " + scoresIncreasing(input1));
            System.out.println(Arrays.toString(input2) + " -> " + scoresIncreasing(input2));
            System.out.println(Arrays.toString(input3) + " -> " + scoresIncreasing(input3));
            System.out.println(Arrays.toString(input4) + " -> " + scoresIncreasing(input4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumHeights(int[] heights, int start, int end) throws Exception{
        if(start < 0 || end >= heights.length) {
            throw  new Exception("Invalid indices.");
        }

        int result = 0;
        for(int i = start; i < end; i++) {
            result += Math.abs(heights[i] - heights[i+1]);
        }
        return result;
    }

    private static void testSumHeights() {
        int[] input = new int[5];

        /* this is the definition of eager initialization*/
        input[0] = 5;
        input[1] = 3;
        input[2] = 6;
        input[3] = 7;
        input[4] = 2;

        try {
            System.out.println(Arrays.toString(input) + " [0, 4] -> " + sumHeights(input, 0, 4));
            System.out.println(Arrays.toString(input) + " [1, 3] -> " + sumHeights(input, 1, 3));
            System.out.println(Arrays.toString(input) + " [1, 6] -> " + sumHeights(input, 1, 6));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        testMonkeyTrouble();
        System.out.println();

        testParrotTrouble();
        System.out.println();

        testPosNeg();
        System.out.println();

        testBackAround();
        System.out.println();

        testEveryNth();
        System.out.println();

        testScoresIncreasing();
        System.out.println();

        testSumHeights();
        System.out.println();
    }
}
