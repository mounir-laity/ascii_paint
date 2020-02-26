package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class CircleTest {

    public CircleTest() {
    }

    @Test
    public void ConstructCircle() {
        Circle circle = new Circle(new Point(5, 5), 3, Color.BLUE);
    }

    @Test
    public void ConstructCircleOutsideOfDrawing() {
        Circle circle = new Circle(new Point(-50, -50), 3, Color.BLUE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructCircleWhenRadiusIsNegative() {
        Circle circle = new Circle(new Point(5, 5), -3, Color.BLUE);

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ConstructCircleWhenRadiusIsZero() {
        Circle circle = new Circle(new Point(5, 5), 0, Color.BLUE);

    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInsideWhenInside() {
        Point p = new Point(5, 5);
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        boolean expResult = true;
        boolean result = circle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInsideWhenNotInside() {
        Point p = new Point(15, 5);
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        boolean expResult = false;
        boolean result = circle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInsideWhenCenter() {
        Point p = new Point(6, 6);
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        boolean expResult = true;
        boolean result = circle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInsideWhenOnEdge() {
        Point p = new Point(9, 6);
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        boolean expResult = true;
        boolean result = circle.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveRight() {
        int dx = 5;
        int dy = 0;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(11, 6), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveDown() {
        int dx = 0;
        int dy = 5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(6, 11), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveLeft() {
        int dx = -5;
        int dy = 0;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(1, 6), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveUp() {
        int dx = 0;
        int dy = -5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(6, 1), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveDownRight() {
        int dx = 5;
        int dy = 5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(11, 11), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveDownLeft() {
        int dx = -5;
        int dy = 5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(1, 11), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveUpRight() {
        int dx = 5;
        int dy = -5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(11, 1), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMoveUpLeft() {
        int dx = -5;
        int dy = -5;
        Circle circle = new Circle(new Point(6, 6), 3, Color.BLUE);
        circle.move(dx, dy);
        Circle expected = new Circle(new Point(1, 1), 3, Color.BLUE);
        assertTrue(circle.equals(expected));
    }
}
