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
public class RectangleTest {
    
    public RectangleTest() {
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInsideWhenInside() {
        System.out.println("isInside");
        Point p = new Point(2,3);
        Point upperLeft = new Point(0,0);
        Rectangle instance = new Rectangle(upperLeft, 4, 3, 't');
        boolean expResult = true;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveWhenBothAreZeros() {
        double dx = 0.0;
        double dy = 0.0;
        Point upperLeft = new Point(2,2);
        Rectangle instance = new Rectangle(upperLeft, 4, 3, 'd');
        Rectangle expResult = new Rectangle(upperLeft, 4, 3, 'd');
        instance.move(dx, dy);
        assertEquals(expResult, instance);
        
    }

    /**
     * Test of equals method, of class Rectangle.
     */
    @Test
    public void testEqualsWhenSimilar() {
        Point upperLeft = new Point(0,0);
        Object obj = new Rectangle(upperLeft, 2, 2, 'f');
        Rectangle instance = new Rectangle(new Point(0,0), 2, 2, 'f');
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsWhenDifferent() {
        Point upperLeft = new Point(0,0);
        Object obj = new Rectangle(upperLeft, 1, 2, 'f');
        Rectangle instance = new Rectangle(new Point(0,0), 2, 2, 'f');
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
