/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class CircleTest {
    
    public CircleTest() {
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test(expected=NullPointerException.class)
    public void testIsInsideWhenPointIsNull() {
        Point p = null;
        Point center = new Point(4,5);
        Circle instance = new Circle(center,2,'c');
        instance.isInside(p);
    }
    
    @Test
    public void testIsInsideWhenInside() {
        Point p = new Point(2, 3);
        Point center = new Point(4,5);
        Circle instance = new Circle(center,3,'c');
        boolean expectedResult = true;
        boolean result =instance.isInside(p);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testIsInsideWhenNotInside() {
        Point p = new Point(2, 3);
        Point center = new Point(4,5);
        Circle instance = new Circle(center,1,'c');
        boolean expectedResult = false;
        boolean result =instance.isInside(p);
        assertEquals(expectedResult, result);
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveWhenBothAreZeros() {
        System.out.println("move");
        double dx = 0.0;
        double dy = 0.0;
        Point center = new Point(1,1);
        Circle instance = new Circle(center, 4, 'l');
        instance.move(dx, dy);
        Point expectedResult = new Point(center);
        assertEquals(center, expectedResult);
    }

    /**
     * Test of getRadius method, of class Circle.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetRadiusWhenNegative() {
        System.out.println("getRadius");
        Point center = new Point(1,1);
        Circle instance = new Circle(center, -2, 'l');
    }
    
}
