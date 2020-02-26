package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class LineTest {
    
    public LineTest() {
    }

    /**
     * Test of isInside method, of class Line.
     */
    @Test
    public void testIsInsideWhenInside() {
        Point p = new Point(10,10);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        boolean expResult = true;
        boolean result = line.isInside(p);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInside method, of class Line.
     */
    @Test
    public void testIsInsideWhenNotInside() {
        Point p = new Point(14,10);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        boolean expResult = false;
        boolean result = line.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveRight() {
        int dx = 5;
        int dy = 0;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(10, 5), new Point(15,10), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveLeft() {
        int dx = -5;
        int dy = 0;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(0, 5), new Point(5,10), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveDown() {
        int dx = 0;
        int dy = 5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(5, 10), new Point(10,15), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveUp() {
        int dx = 0;
        int dy = -5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(5, 0), new Point(10,5), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveDownRight() {
        int dx = 5;
        int dy = 5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(10, 10), new Point(15,15), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveDownLeft() {
        int dx = -5;
        int dy = 5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(0, 10), new Point(5,15), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveUpRight() {
        int dx = 5;
        int dy = -5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(10, 0), new Point(15,5), Color.BLUE);
        assertTrue(line.equals(expected));
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveUpLeft() {
        int dx = -5;
        int dy = -5;
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        line.move(dx, dy);
        Line expected = new Line(new Point(0, 0), new Point(5,5), Color.BLUE);
        assertTrue(line.equals(expected));
    }
}
