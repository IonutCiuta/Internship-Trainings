package splitter;

import com.endava.junit.process.SplitPattern;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by iciuta on 7/21/2016.
 */
public class SplitPatternTest {
    private static SplitPattern splitPattern;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("STARTED: splitter.SplitPatternTest");
        splitPattern = new SplitPattern();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("ENDED: splitter.SplitPatternTest");
    }

    @Test
    public void testGetStringLengthWithSmallInput() {
        String expected = "small";
        String result = splitPattern.getStringLength("test");
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringLengthWithMediumLimitInput() {
        String expected = "medium";
        String result = splitPattern.getStringLength("seven");
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringLengthWithLongInput() {
        String expected = "long";
        String result = splitPattern.getStringLength("adahsdbasuidbaosdaisdbasbdai");
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringLengthWithNullInput() {
        String result = splitPattern.getStringLength(null);
        assertEquals(null, result);
    }

    @Test
    public void testSplitByLength() {
        List<String> expected = new ArrayList<String>();
        expected.add("small");
        expected.add("medium");
        expected.add("long");
        expected.add(null);

        List<String> input = new ArrayList<String>();
        input.add("sky");
        input.add("level 5");
        input.add("maksndaosdnaoisdnaosdnaosndao");
        input.add(null);

        assertEquals(expected, splitPattern.splitByLength(input));
    }
}
