package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by iciuta on 7/18/2016.
 */
public class PenguinFunExtra {
    private static final int COUNT = 800 * 100; //takes ~min to run test
    private static final PenguinHatchery hatchery = new PenguinHatchery();
    private static final Random rand = new Random();

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        efficientTest();
        end = System.currentTimeMillis();
        System.out.println("Test took: " + (end - start));
    }

    private static List<Penguin> getPenguinList() {
        List<Penguin> result = new ArrayList<>();
        for(int i = 0; i < COUNT; i++) {
            result.add(hatchery.hatchPenguin());
        }
        return result;
    }

    private static HashMap<Penguin, Boolean> getPenguinMap(List<Penguin> list) {
        HashMap<Penguin, Boolean> result = new HashMap<>();
        for(Penguin penguin : list) {
            result.put(penguin, true);
        }
        return result;
    }

    @Deprecated
    private static void test() {
        Random rand = new Random();
        int index = rand.nextInt(COUNT);
        long start, end;

        List<Penguin> penguinList = getPenguinList();
        Penguin luckyPenguin = penguinList.get(index);

        /* normal hashcode */
        Penguin.SAME_HASHCODE = false;
        HashMap<Penguin, Boolean> normalHashcodeMap = getPenguinMap(penguinList);

        /* identical hashcode */
        Penguin.SAME_HASHCODE = true;
        HashMap<Penguin, Boolean> identicalHashcodeMap = getPenguinMap(penguinList);

        /* normal hashcode */
        Penguin.SAME_HASHCODE = false;
        start = System.currentTimeMillis();
        normalHashcodeMap.get(luckyPenguin);
        end = System.currentTimeMillis();
        System.out.println("Normal hashcode: " + (end - start));

        /* normal hashcode */
        Penguin.SAME_HASHCODE = true;
        start = System.currentTimeMillis();
        identicalHashcodeMap.get(luckyPenguin);
        end = System.currentTimeMillis();
        System.out.println("Identical hashcode: " + (end - start));
    }

    private static void efficientTest() {
        int theChosenIndex = 67;
        Penguin theChosenPenguin = null;
        long start, end;

        HashMap<Penguin, Boolean> normalHashcodeMap = new HashMap<>();
        HashMap<Penguin, Boolean> identicalHashcodeMap = new HashMap<>();

        for(int  i = 0; i < COUNT; i++) {
            Penguin babyPenguin = hatchery.hatchPenguin();

            if(i == theChosenIndex) {
                theChosenPenguin = babyPenguin;
            }

            Penguin.SAME_HASHCODE = false;
            normalHashcodeMap.put(babyPenguin, true);

            Penguin.SAME_HASHCODE = true;
            identicalHashcodeMap.put(babyPenguin, true);
        }

        /* normal hashcode -> get is occurs instantly*/
        Penguin.SAME_HASHCODE = false;
        start = System.currentTimeMillis();
        normalHashcodeMap.get(theChosenPenguin);
        end = System.currentTimeMillis();
        System.out.println("Normal hashcode: " + (end - start));

        /* same hashcode -> the time difference is noticeable */
        Penguin.SAME_HASHCODE = true;
        start = System.currentTimeMillis();
        identicalHashcodeMap.get(theChosenPenguin);
        end = System.currentTimeMillis();
        System.out.println("Identical hashcode: " + (end - start));
    }
}
