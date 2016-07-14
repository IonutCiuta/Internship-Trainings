package tests;

public class FlowMain {
    private static final int SIZE = 10;

    private static int[] initData() {
        int[] result = new int[SIZE];

        for(int i = 0 ; i < SIZE; i++) {
            result[i] = (i + 1) * 3 - 2;
        }

        return result;
    }

    private static void testPrimitiveIterator() {
        int[] data = initData();

        for(int i : data) {
            System.out.println(i + "");
        }
    }

    public static void main(String[] args) {
        testPrimitiveIterator();
    }
}
