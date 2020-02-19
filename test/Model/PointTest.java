/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import g53649.AsciiPaint.model.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class PointTest {
    
    public PointTest() {
    }

    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void testDistanceToWhenSamePlace() {
        Point other = new Point(2,3);
        Point instance = new Point(2,3);
        double expResult = 0.0;
        double result = instance.distanceTo(other);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void EqualsWhenSimilar() {
        Point other = new Point(2,3);
        Point instance = new Point(2,3);
        boolean expResult = true;
        boolean Result = instance.equals(other);
        assertEquals(expResult, Result);
    }
    
    @Test
    public void EqualsWhenDifferent() {
        Point other = new Point(0,3);
        Point instance = new Point(2,3);
        boolean expResult = true;
        boolean Result = instance.equals(other);
        assertEquals(expResult, Result);
    }
    @Test
    public void EqualsWhenDifferentType() {
    Point other = new Point(2,3);
        Point instance = new Point(2,3);
        boolean expResult = true;
        boolean Result = instance.equals(other);
        assertEquals(expResult, Result);
}
    
}
