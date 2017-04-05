package com.freblogg.hashing;

import static com.freblogg.hashing.FNV.fnv132;
import static com.freblogg.hashing.FNV.fnv164;
import static com.freblogg.hashing.FNV.fnv1a32;
import static com.freblogg.hashing.FNV.fnv1a64;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Created by swaroop on 04-04-2017.
 */
public class FNVTest {
    @Test
    public void fnv132Test() {
        assertEquals("b6fa7167", fnv132("hello"));
        assertEquals("9b8e862f", fnv132("world"));
        assertEquals("6c210a94", fnv132("Fowler"));
        assertEquals("8fa9cc54", fnv132("Noll"));
        assertEquals("3b76d984", fnv132("Vo"));

        assertNotEquals(fnv132("Swaroop"), fnv132("swaroop"));
    }

    @Test
    public void fnv1a32Test() {
        assertEquals("4f9f2cab", fnv1a32("hello"));
        assertEquals("37a3e893", fnv1a32("world"));
        assertEquals("3c5c0bf2", fnv1a32("Fowler"));
        assertEquals("0b543aea", fnv1a32("Noll"));
        assertEquals("41fa1372", fnv1a32("Vo"));

        assertNotEquals(fnv1a32("Swaroop"), fnv1a32("swaroop"));
    }

    @Test
    public void fnv164Test() {
        assertEquals("7b495389bdbdd4c7", fnv164("hello"));
        assertEquals("3ec0cf0cc4a6540f", fnv164("world"));
        assertEquals("2ffe3fff0c5fb874", fnv164("Fowler"));
        assertEquals("a859f67e1e22acf4", fnv164("Noll"));
        assertEquals("08323207b4eadda4", fnv164("Vo"));

        assertNotEquals(fnv164("Swaroop"), fnv164("swaroop"));
    }

    @Test
    public void fnv1a64Test() {
        assertEquals("a430d84680aabd0b", fnv1a64("hello"));
        assertEquals("4f59ff5e730c8af3", fnv1a64("world"));
        assertEquals("ece1e2c7181d9872", fnv1a64("Fowler"));
        assertEquals("66a1f3c6d2dfa92a", fnv1a64("Noll"));
        assertEquals("093b3907b5cbfe32", fnv1a64("Vo"));

        assertNotEquals(fnv1a64("Swaroop"), fnv1a64("swaroop"));
    }
}
