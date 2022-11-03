package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void test(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,2);
        Vector2d vector3 = new Vector2d(5,3);
        Vector2d vector4 = new Vector2d(-2,2);
        Vector2d vector5 = new Vector2d(-2,2);
        Vector2d vector6 = new Vector2d(10,0);
//        Precedes
        assertTrue(vector1.precedes(vector2));
        assertFalse(vector3.precedes(vector4));
//        toString
        System.out.println("(" + vector1 + ")");
        System.out.println("(" + vector2 + ")");
        System.out.println("(" + vector3+ ")");
        System.out.println("(" + vector4 + ")");
//        equals
        assertFalse(vector4.equals(vector2));
        assertTrue(vector4.equals(vector5));
//        follows
        assertTrue(vector3.follows(vector1));
        assertTrue(vector4.follows(vector5));
        assertFalse(vector5.follows(vector2));
//        upperRight
        System.out.println("upperRight");
        assertEquals(new Vector2d(10,2),vector1.upperRight(vector6));
        assertEquals(new Vector2d(2,2),vector2.upperRight(vector4));
        assertEquals(new Vector2d(-2,2),vector4.upperRight(vector4));
        System.out.println(vector1.upperRight(vector6));
        System.out.println(vector2.upperRight(vector4));
        System.out.println(vector4.upperRight(vector4));
//        lowerLeft
        System.out.println("lowerLeft");
        assertEquals(new Vector2d(1,0),vector1.lowerLeft(vector6));
        assertEquals(new Vector2d(-2,2),vector2.lowerLeft(vector4));
        assertEquals(new Vector2d(-2,2),vector4.lowerLeft(vector4));
        System.out.println(vector1.lowerLeft(vector6));
        System.out.println(vector2.lowerLeft(vector4));
        System.out.println(vector4.lowerLeft(vector4));
//        add
        System.out.println("add");
        assertEquals(new Vector2d(2+5, 2+3),vector2.add(vector3));
        assertEquals(new Vector2d(1+10,2+0),vector1.add(vector6));
        assertEquals(new Vector2d(2+(-2), 2+2),vector2.add(vector4));
        assertEquals(new Vector2d(-2+(-2), 2+2),vector4.add(vector5));
        System.out.println(vector2.add(vector3));
        System.out.println(vector1.add(vector6));
        System.out.println(vector2.add(vector4));
        System.out.println(vector4.add(vector5));
//        substract
        System.out.println("substract");
        assertEquals(new Vector2d(2-5, 2-3),vector2.subtract(vector3));
        assertEquals(new Vector2d(1-10,2-0),vector1.subtract(vector6));
        assertEquals(new Vector2d(2-(-2), 2-2),vector2.subtract(vector4));
        assertEquals(new Vector2d(-2-(-2), 2-2),vector4.subtract(vector5));
        System.out.println(vector2.subtract(vector3));
        System.out.println(vector1.subtract(vector6));
        System.out.println(vector2.subtract(vector4));
        System.out.println(vector4.subtract(vector5));
//        equals
        System.out.println("equals");
        assertFalse(vector2.equals(vector3));
        assertFalse(vector1.equals(vector6));
        assertFalse(vector2.equals(vector4));
        assertTrue(vector4.equals(vector5));
        System.out.println(vector2.equals(vector3));
        System.out.println(vector1.equals(vector6));
        System.out.println(vector2.equals(vector4));
        System.out.println(vector4.equals(vector5));
//        opposite
        System.out.println("opposite");
        assertEquals(new Vector2d(2,-2),vector4.opposite());
        assertEquals(new Vector2d(-10,0),vector6.opposite());
        assertEquals(new Vector2d(-5,-3),vector3.opposite());
        assertEquals(new Vector2d(2,-2),vector5.opposite());
        System.out.println(vector4.opposite());
        System.out.println(vector6.opposite());
        System.out.println(vector3.opposite());
        System.out.println(vector5.opposite());





    }
}
