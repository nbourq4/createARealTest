package delft;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberManagerTest {
    private NumberManager numberManager;

    @BeforeEach
    void setUp() {
        numberManager = new NumberManager();
    }

    @Test
    void testAddNumber() {
        numberManager.addNumber(5);
        assertEquals(1, numberManager.getNumbers().size(), "The list should contain one number.");
        assertEquals(5, numberManager.getNumbers().get(0), "The number in the list should be 5.");
    }

    @Test
    void testGetSumWithMultipleNumbers() {
        numberManager.addNumber(5);
        numberManager.addNumber(10);
        numberManager.addNumber(20);
        assertEquals(35, numberManager.getSum(), "The sum of the numbers should be 35.");
    }

    @Test
    void testGetSumEmptyList() {
        assertEquals(0, numberManager.getSum(), "The sum of an empty list should be 0.");
    }

    @Test
    void testGetMaxWithMultipleNumbers() {
        numberManager.addNumber(5);
        numberManager.addNumber(10);
        numberManager.addNumber(20);
        assertEquals(20, numberManager.getMax(), "The maximum number should be 20.");
    }

    @Test
    void testGetMaxEmptyList() {
        Exception exception = assertThrows(IllegalStateException.class, () -> numberManager.getMax());
        assertEquals("No numbers in the list", exception.getMessage(), "Expected IllegalStateException for empty list.");
    }

    @Test
    void testClear() {
        numberManager.addNumber(5);
        numberManager.addNumber(10);
        numberManager.clear();
        assertTrue(numberManager.getNumbers().isEmpty(), "The list should be empty after clear.");
    }

    @Test
    void testGetNumbers() {
        numberManager.addNumber(5);
        numberManager.addNumber(10);
        List<Integer> numbers = numberManager.getNumbers();
        assertEquals(2, numbers.size(), "The list should contain two numbers.");
        assertEquals(5, numbers.get(0), "The first number should be 5.");
        assertEquals(10, numbers.get(1), "The second number should be 10.");
    }
}
