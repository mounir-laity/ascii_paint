package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class AsciiPaintTest {

    public AsciiPaintTest() {
    }

    /**
     * Test of newCircle method, of class AsciiPaint.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewCircleWithNegativeRadius() {
        int x = 0;
        int y = 0;
        int radius = -2;
        Color color = Color.BLUE;
        AsciiPaint ascii = new AsciiPaint(20, 20);
        ascii.newCircle(x, y, radius, color);
    }

    /**
     * Test of newCircle method, of class AsciiPaint.
     */
    @Test
    public void testNewCircle() {
        int x = 0;
        int y = 0;
        int radius = 2;
        Color color = Color.BLUE;
        AsciiPaint ascii = new AsciiPaint(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        ascii.newCircle(x, y, radius, color);
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewRectangleWithNegativeWidth() {
        int x = 0;
        int y = 0;
        int width = -5;
        int height = 5;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newRectangle(x, y, width, height, color);
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewRectangleWithNegativeHeight() {
        int x = 0;
        int y = 0;
        int width = 5;
        int height = -5;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newRectangle(x, y, width, height, color);
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test
    public void testNewRectangle() {
        int x = 0;
        int y = 0;
        int width = 5;
        int height = 5;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newRectangle(x, y, width, height, color);
    }

    /**
     * Test of newSquare method, of class AsciiPaint.
     */
    @Test
    public void testNewSquare() {
        int x = 0;
        int y = 0;
        int side = 4;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newSquare(x, y, side, color);
    }

    /**
     * Test of newSquare method, of class AsciiPaint.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewSquareWithNegativeSide() {
        int x = 0;
        int y = 0;
        int side = -4;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newSquare(x, y, side, color);
    }

    /**
     * Test of newLine method, of class AsciiPaint.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNewLineWhenBothAreTheSame() {
        int p1x = 0;
        int p1y = 0;
        int p2x = 0;
        int p2y = 0;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newLine(p1x, p1y, p2x, p2y, color);
    }

    /**
     * Test of newLine method, of class AsciiPaint.
     */
    @Test
    public void testNewLine() {
        int p1x = 0;
        int p1y = 0;
        int p2x = 5;
        int p2y = 5;
        Color color = Color.BLUE;
        AsciiPaint instance = new AsciiPaint(20, 20);
        instance.newLine(p1x, p1y, p2x, p2y, color);
    }

    /**
     * Test of convertToColor method, of class AsciiPaint.
     */
    @Test
    public void testConvertToColor() {
        System.out.println("convertToColor");
        char c = 'c';
        AsciiPaint instance = new AsciiPaint(20, 20);
        Color expResult = Color.CYAN;
        Color result = instance.convertToColor(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToColor method, of class AsciiPaint.
     */
    @Test
    public void testConvertToDefaultColor() {
        System.out.println("convertToColor");
        char c = 'x';
        AsciiPaint instance = new AsciiPaint(20, 20);
        Color expResult = Color.DEFAULT;
        Color result = instance.convertToColor(c);
        assertEquals(expResult, result);
    }

}
