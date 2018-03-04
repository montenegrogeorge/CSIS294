package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class AListTest {

    private AList list;
    private int k;

    @Before
    public void setUp() {
        final String[] cities = {"Tokyo","New York","Sao Paulo","Seoul"};
        k = cities.length;
        list = new AList(cities);
    }

    /**
     * Check that the list has the correct size.
     */
    @Test
    public void testSize() {
        assertEquals(k,list.size());
    }

    /**
     * Check that adding returns the just added object and the the size increased.
     * Check that adding the same object again, still does increase the size.
     */
    @Test
    public void testAddition() {
        final Object obj = list.add("Berlin");
        assertEquals(obj,"Berlin");
        assertTrue(k+1 == list.size());
    }

    /**
     * Check that removal returns the just removed object and the the size decreased.
     * Check that removing an object that's not in the list behaves reasonably.
     */
    @Test
    public void testRemoval() {
        Object obj = list.remove("New York");
        assertEquals(obj,"New York");
        assertTrue(k-1 == list.size());

        obj = list.remove("New York");
        assertNull(obj);
        assertTrue(k-1 == list.size());
    }

    @Test
    public void test2String() {
        list.remove("Tokyo");
        list.remove("Seoul");
        list.add("San Diego");

        assertEquals("New York, Sao Paulo, San Diego",list.toString());
    }
}
