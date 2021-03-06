/*
 * HeapTest.java
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algos.Heap;

/**
 * Tests for the Heap class
 */
public class HeapTest
{

    /**
     * Basic tests
     */
    @Test
    public void test()
    {
        Heap<Integer> heap = new Heap<Integer>(4);
        assertEquals("[null, null, null, null]", heap.toString());
        assertEquals(null, heap.findMin());
        assertEquals(0, heap.size());
        assertEquals(null, heap.extractMin());
        assertEquals(0, heap.size());
        heap.insert(3);
        assertEquals("[3, null, null, null]", heap.toString());
        assertEquals(3, (int)heap.findMin());
        assertEquals(1, heap.size());
        heap.insert(5);
        assertEquals("[3, 5, null, null]", heap.toString());
        assertEquals(3, (int)heap.findMin());
        assertEquals(2, heap.size());
        heap.insert(1);
        assertEquals("[1, 5, 3, null]", heap.toString());
        assertEquals(1, (int)heap.findMin());
        assertEquals(3, heap.size());
        assertEquals(1, (int)heap.extractMin());
        assertEquals("[3, 5, 3, null]", heap.toString());
        assertEquals(3, (int)heap.findMin());
        assertEquals(2, heap.size());
    }

    /**
     * Test the exception we get if we try to fill the heap beyond capacity
     */
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testBoundaries()
    {
        Heap<Integer> heap = new Heap<Integer>(2);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
    }
}
