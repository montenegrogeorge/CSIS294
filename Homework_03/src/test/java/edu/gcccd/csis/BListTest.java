package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class BListTest {

    private BList list;
    private int k;


    @Before
    public void setUp() {
        final String[] cities = {"Tokyo","New York","Sao Paulo","Seoul"};
        k = cities.length;
        list = new BList(cities);
    }


    @Test
    public void testSize() {
        assertEquals(k,list.size());
    }


    @Test
    public void testAddition() {
        final String s = list.add("Berlin");
        assertEquals(s,"Berlin");
        assertTrue(k+1 == list.size());
    }


    @Test
    public void testRemoval() {
        String s = list.remove("New York");
        assertEquals(s,"New York");
        assertTrue(k-1 == list.size());

        s = list.remove("New York");
        assertNull(s);
        assertTrue(k-1 == list.size());
    }

    @Test
    public void test2String() {
        list.remove("Tokyo");
        list.remove("Seoul");
        list.add("San Diego");
        list.reverse();
        assertEquals("San Diego, Sao Paulo, New York",list.toString());
    }

    @Test
    public void test2Longest()
    {
        list.remove("Sao Paulo");
        assertEquals("New York", list.getLongest());
    }

    @Test
    public void test2reverse() {

        list.reverse();
        list.add("San Diego");

        assertEquals("Seoul, Sao Paulo, New York, Tokyo, San Diego",list.toString());
    }
}
