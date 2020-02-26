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
    public void testIsInside() {
        System.out.println("isInside");
        Point p = null;
        Line instance = null;
        boolean expResult = false;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int dx = 0;
        int dy = 0;
        Line instance = null;
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
