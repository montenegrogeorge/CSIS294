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

            String sa = s.dequeue();
            String sb = s.dequeue();
            String sc = s.dequeue();

            assertEquals("First", sa);
            assertEquals("Second", sb);
            assertEquals("Third", sc);


        }

        @Test
        public void EmptyTest() {
            GenericQueue<Integer> sa = new GenericQueue<>();

            assertTrue(sa.dequeue() == null );

        }


}



