package edu.gcccd.csis;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenericQueueTest {
        @Test
        public void intTest() {

            GenericQueue<Integer> si = new GenericQueue<>(5);

            si.enqueue(1);
            si.enqueue(2);
            si.enqueue(3);

            int ia = si.dequeue();
            int ib = si.dequeue();
            int ic = si.dequeue();

            assertEquals(1, ia);
            assertEquals(2, ib);
            assertEquals(3, ic);
        }
        
        @Test
        public void StringTest() {
            // String Test
            GenericQueue<String> s = new GenericQueue<>(5);
            s.enqueue("First");
            s.enqueue("Second");
            s.enqueue("Third");
            s.enqueue("Fourth");

            String sa = s.dequeue();
            String sb = s.dequeue();
            String sc = s.dequeue();
            String sd = s.dequeue();

            assertEquals("First", sa);
            assertEquals("Second", sb);
            assertEquals("Third", sc);
            assertEquals("Fourth", sd);
        }

        @Test
        public void EmptyTest() {
            GenericQueue<Integer> sa = new GenericQueue<>();
            assertTrue(sa.dequeue() == null );
        }

        @Test
        public void sizeTest() {
            GenericQueue<Integer> si = new GenericQueue<>();
            si.enqueue(10);
            assertEquals(1, si.length());
            si.enqueue(11);
            assertEquals(2, si.length());
            si.enqueue(12);
            si.enqueue(13);
            assertEquals(4, si.length());
        }


}



