package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class RectangleTest {

    public RectangleTest() {
    }

    @Test
    public void constructRectangle() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 1, 1, Color.BLUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructRectangleWhenWidthIsNegative() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), -1, 1, Color.BLUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructRectangleWhenHeightIsNegative() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 1, -1, Color.BLUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructRectangleWhenBothAreNegative() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), -1, -1, Color.BLUE);
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInsideWhenInside() {
        Point p = new Point(10, 10);
        Rectangle rectangle = new Rectangle(new Point(8, 8), 4, 4, Color.BLUE);
        boolean expResult = true;
        boolean result = rectangle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInsideWhenUpperLeft() {
        Point p = new Point(8, 8);
        Rectangle rectangle = new Rectangle(new Point(8, 8), 4, 4, Color.BLUE);
        boolean expResult = true;
        boolean result = rectangle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInsideWhenNotInside() {
        Point p = new Point(15, 10);
        Rectangle rectangle = new Rectangle(new Point(8, 8), 4, 4, Color.BLUE);
        boolean expResult = false;
        boolean result = rectangle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveRight() {
        int dx = 5;
        int dy = 0;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(11, 6), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveLeft() {
        int dx = -5;
        int dy = 0;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(1, 6), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveDown() {
        int dx = 0;
        int dy = 5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(6, 11), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveUp() {
        int dx = 0;
        int dy = -5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(6, 1), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveUpLeft() {
        int dx = -5;
        int dy = -5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(1, 1), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveUpRight() {
        int dx = 5;
        int dy = -5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(11, 1), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveDownRight() {
        int dx = 5;
        int dy = 5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(11, 11), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMoveDownLeft() {
        int dx = -5;
        int dy = 5;
        Rectangle rectangle = new Rectangle(new Point(6, 6), 3, 4, Color.BLUE);
        rectangle.move(dx, dy);
        Rectangle expected = new Rectangle(new Point(1, 11), 3, 4, Color.BLUE);
        assertTrue(rectangle.equals(expected));
    }
}
