import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringManipulatorTest {
    @Test
    void canConcatenate() {
        StringManipulator m = new StringManipulator();
        String result = m.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    void canFindLength() {
        StringManipulator m = new StringManipulator();
        int result = m.findLength("Hello");
        assertEquals(5, result);
    }

    @Test
    void canConvertToUpperCase() {
        StringManipulator m = new StringManipulator();
        String result = m.convertToUpperCase("Hello");
        assertEquals("HELLO", result);
    }

    @Test
    void canConvertToLowerCase() {
        StringManipulator m = new StringManipulator();
        String result = m.convertToLowerCase("HeLlO");
        assertEquals("hello", result);
    }

    @Test
    void canCheckSubstring() {
        StringManipulator m = new StringManipulator();
        boolean result = m.containsSubstring("Hello", "ell");
        assertTrue(result);
    }
}
