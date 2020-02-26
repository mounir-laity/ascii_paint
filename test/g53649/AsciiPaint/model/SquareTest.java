/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class SquareTest {
    
    public SquareTest() {
    }

    @Test
    public void testConstructSquare() {
        Square square = new Square(new Point(0, 0), 1, Color.BLUE);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConstructSquareWhenSideIsZero() {
        Square square = new Square(new Point(0, 0), 0, Color.BLUE);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConstructSquareWhenSideIsNegative() {
        Square square = new Square(new Point(0, 0), -5, Color.BLUE);
    }
    
}
