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
public class GroupTest {

    public GroupTest() {
    }

    /**
     * Test of addShape method, of class Group.
     */
    @Test
    public void testAddShape() {
        Shape square = new Square(new Point(5, 5), 4, Color.BLUE);
        Shape rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Group group = new Group(Color.BLUE);
        group.addShape(square);
        group.addShape(rectangle);
        assertTrue(group.getShapes().contains(square) && group.getShapes().contains(rectangle)
                && group.getShapes().size() == 2);
    }
    
    /**
     * Test of addShape method, of class Group.
     */
    @Test
    public void testAddGroup() {
        Shape square = new Square(new Point(5, 5), 4, Color.BLUE);
        Shape rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Group group = new Group(Color.BLUE);
        group.addShape(square);
        group.addShape(rectangle);
        Group group2 = new Group(Color.BLUE);
        group2.addShape(group);
        assertTrue(group2.getShapes().contains(group) && group2.getShapes().size() == 1);
    }

    /**
     * Test of move method, of class Group.
     */
    @Test
    public void testMoveRight() {
        int dx = 6;
        int dy = 0;
        Group group = new Group(Color.BLUE);
        Circle circle = new Circle(new Point(5, 5), 4, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Rectangle rectangle2 = new Rectangle(new Point(11, 5), 4, 6, Color.BLUE);
        Circle circle2 = new Circle(new Point(11, 5), 4, Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        group.move(dx, dy);
        assertTrue(group.getShapes().get(0).equals(circle2) &&
               group.getShapes().get(1).equals(rectangle2) &&
                group.getShapes().size() == 2);
    }
    
    /**
     * Test of move method, of class Group.
     */
    @Test
    public void testMoveLeft() {
        int dx = -2;
        int dy = 0;
        Group group = new Group(Color.BLUE);
        Circle circle = new Circle(new Point(5, 5), 4, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Rectangle rectangle2 = new Rectangle(new Point(3, 5), 4, 6, Color.BLUE);
        Circle circle2 = new Circle(new Point(3, 5), 4, Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        group.move(dx, dy);
        assertTrue(group.getShapes().get(0).equals(circle2) &&
               group.getShapes().get(1).equals(rectangle2) &&
                group.getShapes().size() == 2);
    }
    
    /**
     * Test of move method, of class Group.
     */
    @Test
    public void testMoveDown() {
        int dx = 0;
        int dy = 5;
        Group group = new Group(Color.BLUE);
        Circle circle = new Circle(new Point(5, 5), 4, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Rectangle rectangle2 = new Rectangle(new Point(5, 10), 4, 6, Color.BLUE);
        Circle circle2 = new Circle(new Point(5, 10), 4, Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        group.move(dx, dy);
        assertTrue(group.getShapes().get(0).equals(circle2) &&
               group.getShapes().get(1).equals(rectangle2) &&
                group.getShapes().size() == 2);
    }
    
    /**
     * Test of move method, of class Group.
     */
    @Test
    public void testMoveUp() {
        int dx = 0;
        int dy = -3;
        Group group = new Group(Color.BLUE);
        Circle circle = new Circle(new Point(5, 5), 4, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(5, 5), 4, 6, Color.BLUE);
        Rectangle rectangle2 = new Rectangle(new Point(5, 2), 4, 6, Color.BLUE);
        Circle circle2 = new Circle(new Point(5, 2), 4, Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        group.move(dx, dy);
        assertTrue(group.getShapes().get(0).equals(circle2) &&
               group.getShapes().get(1).equals(rectangle2) &&
                group.getShapes().size() == 2);
    }

    /**
     * Test of isInside method, of class Group.
     */
    @Test
    public void testIsInsideWhenInside() {
        Point p = new Point(5,5);
        Circle circle = new Circle(new Point(3, 3), 3, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(10, 10), 4, 3, Color.BLUE);
        Group group = new Group(Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        boolean expResult = true;
        boolean result = group.isInside(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Group.
     */
    @Test
    public void testIsInsideWhenNotInside() {
        Point p = new Point(5,5);
        Circle circle = new Circle(new Point(3, 3), 2, Color.BLUE);
        Rectangle rectangle = new Rectangle(new Point(10, 10), 4, 3, Color.BLUE);
        Group group = new Group(Color.BLUE);
        group.addShape(circle);
        group.addShape(rectangle);
        boolean expResult = false;
        boolean result = group.isInside(p);
        assertEquals(expResult, result);
    }

}
