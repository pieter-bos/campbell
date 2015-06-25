package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashListTest {
    @Test
    public void testEmptyList() {
        HashList<Integer> left = new HashList<>();
        HashList<Integer> right = new HashList<>();

        assertTrue(left.equals(right));
    }
}