package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class PointTest {

    public PointTest() {
    }
    
    @Test
    public void testConstructPoint() {
        Point p = new Point(0, 0);
    }
    
    @Test
    public void testConstructPointWithNegativeValues() {
        Point p = new Point(-5, -5);
    }
    
    @Test (expected = NullPointerException.class)
    public void testConstructPointWhenOtherPointIsNull() {
        Point p = new Point(null);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMoveRight() {
        int dx = 5;
        int dy = 0;
        Point point = new Point(5, 5);
        point.move(dx, dy);
        Point expPoint = new Point(10, 5);
        assertEquals(expPoint, point);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMoveDown() {
        int dx = 0;
        int dy = 5;
        Point point = new Point(5, 5);
        point.move(dx, dy);
        Point expPoint = new Point(5, 10);
        assertEquals(expPoint, point);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMoveLeft() {
        int dx = -5;
        int dy = 0;
        Point point = new Point(5, 5);
        point.move(dx, dy);
        Point expPoint = new Point(0, 5);
        assertEquals(expPoint, point);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMoveUp() {
        int dx = 0;
        int dy = -5;
        Point point = new Point(5, 5);
        point.move(dx, dy);
        Point expPoint = new Point(5, 0);
        assertEquals(expPoint, point);
    }

    /**
     * Test of move method, of class Point.
     */
    @Test
    public void testMoveDiagonally() {
        int dx = 5;
        int dy = -5;
        Point point = new Point(5, 5);
        point.move(dx, dy);
        Point expPoint = new Point(10, 0);
        assertEquals(expPoint, point);
    }

    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void testDistanceToWhenSamePoint() {
        Point point = new Point(10, 10);
        double expResult = 0.0;
        double result = point.distanceTo(point);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void testDistanceToHorizontal() {
        Point point = new Point(10, 10);
        Point point2 = new Point(15, 10);
        double expResult = 5.0;
        double result = point.distanceTo(point2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distanceTo method, of class Point.
     */
    @Test
    public void testDistanceToVertical() {
        Point point = new Point(10, 10);
        Point point2 = new Point(10, 15);
        double expResult = 5.0;
        double result = point.distanceTo(point2);
        assertEquals(expResult, result, 0.0);
    }

}
