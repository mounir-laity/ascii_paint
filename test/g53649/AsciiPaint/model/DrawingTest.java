package g53649.AsciiPaint.model;

import java.util.List;
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
    @Test
    public void testAddOneShape() {
        System.out.println("addShape");
        Shape shape = new Circle(new Point(5, 5), 4, Color.BLUE);
        Drawing drawing = new Drawing(20, 20);
        drawing.addShape(shape);
        assertTrue(drawing.getShapes().get(0) == shape && drawing.getShapes().size() == 1);
    }

    /**
     * Test of addShape method, of class Drawing.
     */
    @Test
    public void testAddMultipleShapes() {
        System.out.println("addShape");
        Circle circle = new Circle(new Point(5, 5), 4, Color.BLUE);
        Circle circle2 = new Circle(new Point(5, 5), 5, Color.BLUE);
        Circle circle3 = new Circle(new Point(1, 5), 4, Color.RED);
        Drawing drawing = new Drawing(20, 20);
        drawing.addShape(circle);
        drawing.addShape(circle2);
        drawing.addShape(circle3);
        assertTrue(drawing.getShapes().get(0) == circle
                && drawing.getShapes().get(1) == circle2
                && drawing.getShapes().get(2) == circle3
                && drawing.getShapes().size() == 3);
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAtWhenOneShapeAt() {
        Point p = new Point(5, 5);
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(4, 4), 2, Color.BLUE);
        drawing.addShape(circle);
        Shape expResult = circle;
        Shape result = drawing.getShapeAt(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAtWhenMultipleShapesAt() {
        Point p = new Point(5, 5);
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(4, 4), 2, Color.BLUE);
        Circle circle2 = new Circle(new Point(0, 0), 10, Color.BLUE);
        drawing.addShape(circle);
        drawing.addShape(circle2);
        Shape expResult = circle2;
        Shape result = drawing.getShapeAt(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAtWhenNoShapeAt() {
        Point p = new Point(5, 5);
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        Shape expResult = null;
        Shape result = drawing.getShapeAt(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Drawing.
     */
    @Test
    public void testMove() {
        Drawing drawing = new Drawing(20, 20);
        int index = 0;
        int dx = 5;
        int dy = 0;
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        Circle expected = new Circle(new Point(5, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.move(index, dx, dy);
        assertEquals(expected, drawing.getShapes().get(index));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveWhenIncorrectIndex() {
        Drawing drawing = new Drawing(20, 20);
        int index = 2;
        int dx = 5;
        int dy = 0;
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        Circle expected = new Circle(new Point(5, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.move(index, dx, dy);
        assertEquals(expected, drawing.getShapes().get(index));
    }

    /**
     * Test of changeColor method, of class Drawing.
     */
    @Test
    public void testChangeColor() {
        int index = 0;
        Color color = Color.CYAN;
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.changeColor(index, color);
        assertTrue(drawing.getShapes().get(index).getColor().equals(color));
    }

    /**
     * Test of changeColor method, of class Drawing.
     */
    @Test
    public void testChangeColorToSameColor() {
        int index = 0;
        Color color = Color.BLUE;
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.changeColor(index, color);
        assertTrue(drawing.getShapes().get(index).getColor().equals(color));
    }

    /**
     * Test of remove method, of class Drawing.
     */
    @Test
    public void testRemove() {
        int index = 0;
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.remove(index);
        assertTrue(drawing.getShapes().isEmpty());
    }

    /**
     * Test of remove method, of class Drawing.
     */
    @Test
    public void testRemoveASingleForm() {
        int index = 0;
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        Circle circle2 = new Circle(new Point(4, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.addShape(circle2);
        drawing.remove(index);
        assertTrue(drawing.getShapes().get(0).equals(circle2));
    }

    /**
     * Test of remove method, of class Drawing.
     */
    @Test
    public void testRemoveAllForms() {
        int index = 0;
        Drawing drawing = new Drawing(20, 20);
        Circle circle = new Circle(new Point(0, 0), 2, Color.BLUE);
        Circle circle2 = new Circle(new Point(4, 0), 2, Color.BLUE);
        drawing.addShape(circle);
        drawing.addShape(circle2);
        drawing.remove(index);
        drawing.remove(index);
        assertTrue(drawing.getShapes().isEmpty());
    }

    /**
     * Test of remove method, of class Drawing.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFormWhenShapesIsEmpty() {
        int index = 0;
        Drawing drawing = new Drawing(20, 20);
        drawing.remove(index);
        assertTrue(drawing.getShapes().isEmpty());
    }

}
