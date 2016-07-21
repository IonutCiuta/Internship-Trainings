import com.endava.junit.process.ProcessPattern;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by iciuta on 7/21/2016.
 */
public class GeneratePositionTest {
    private static ProcessPattern processPattern;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("STARTED: GeneratePositionTest");
        processPattern = new ProcessPattern();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("ENDED: GeneratePositionTest");
    }

    @Before
    public void setUp() {
        System.out.println(getClass().getSimpleName() + " BEFORE TEST");
    }

    @After
    public void tearDown() {
        System.out.println(getClass().getSimpleName() + " AFTER TEST");
    }

    @Test
    public void testGeneratePositionForJuniorGrade() {
        String expected = "Junior Developer";
        String result = processPattern.generatePosition("junior", 100);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForMiddle1Grade() {
        String expected = "Developer 1";
        String result = processPattern.generatePosition("middle", 1);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForMiddle2Grade() {
        String expected = "Developer 2";
        String result = processPattern.generatePosition("middle", 3);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForSenior1Grade() {
        String expected = "Senior 1";
        String result = processPattern.generatePosition("senior", 4);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForSenior2Grade() {
        String expected = "Senior 2";
        String result = processPattern.generatePosition("senior", 6);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForUnknownGrade() {
        String expected = "Unknown Position";
        String result = processPattern.generatePosition("master", 1);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForNullGrade() {
        String expected = null;
        String result = processPattern.generatePosition(null, 1);
        assertEquals(expected, result);
    }

    @Test
    public void testGeneratePositionForNegativeAge() {
        String expected = null;
        String result = processPattern.generatePosition("junior", -1);
        assertEquals(expected, result);
    }
}
