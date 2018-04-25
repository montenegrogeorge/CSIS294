package edu.gcccd.csis;

import org.junit.Test;
import java.util.Random;
import java.lang.String;
import static org.junit.Assert.*;

public class RecursionTest {


    @Test
    public void printEveryOther() {
        Recursion rt = new Recursion();
        int[] ia = {1, 2, 3};
        int[] tst = {1};

        String r = rt.printEveryOther(tst, 1);
        String s = rt.printEveryOther(ia, 1);
        String t = rt.printEveryOther(ia, 2);

        // Check
        assertTrue(s.equals("2"));

        // Edge Check
        assertTrue(r.equals("1"));



    }

    @Test
    public void printStars() {
        Recursion rt = new Recursion();

        //Edge case checks
        String s = rt.printStars("aa");
        String r = rt.printStars("s");
        String tst = "a*a";
        assertTrue(r.equals("s"));
        assertTrue(s.equals(tst));

        // Long test
        String l = "RREEAAALLLLLLLHARD";
        String lstar = rt.printStars(l);
        assertTrue(lstar.equals("R*RE*EA*A*AL*L*L*L*L*L*LHARD"));
    }

    /*
     * we know the sum of the 1st k positive numbers is n(n+1)2
     */
    @Test
    public void sum() {
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            assertEquals(k * (k + 1) / 2, Recursion.sum(k));
        }
        // corner cases
        assertEquals(0, Recursion.sum(-1));
        assertEquals(0, Recursion.sum(0));
        try {
            int x = Recursion.sum(Integer.MAX_VALUE); // stackoverflow
            fail();
        } catch (StackOverflowError error) {
            assertTrue(true);
        }
    }
}
