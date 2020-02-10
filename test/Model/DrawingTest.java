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
public class DrawingTest {

    public DrawingTest() {
    }

    /**
     * Test of addShape method, of class Drawing.
     */
    @Test(expected = NullPointerException.class)
    public void testAddShape() {
        Shape shape = null;
        Drawing instance = null;
        instance.addShape(shape);
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test(expected = NullPointerException.class)
    public void testGetShapeAtWhenPointIsNull() {
        Point p = null;
        Drawing instance = new Drawing(20, 20);
        instance.getShapeAt(p);
    }

    /**
     * Test of getHeight method, of class Drawing.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetHeightWhenHeightIsNegative() {
        Drawing instance = new Drawing(-2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWidthWhenHeightIsNegative() {
        Drawing instance = new Drawing(2, -4);
    }

}
