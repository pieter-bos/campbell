package util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for HashList
 */
public class HashListTest {
    /**
     * Test in case the list is empty
     */
    @Test
    public void testEmptyList() {
        HashList<Integer> left = new HashList<>();
        HashList<Integer> right = new HashList<>();

        assertTrue(left.equals(right));
    }
}