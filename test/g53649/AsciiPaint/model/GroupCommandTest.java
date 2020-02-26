package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class GroupCommandTest {
    
    public GroupCommandTest() {
    }

    /**
     * Test of execute method, of class GroupCommand.
     */
    @Test
    public void testExecute() {
        Drawing drawing = new Drawing(20, 20);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        Square square = new Square(new Point(5,5), 4, Color.BLUE);
        drawing.addShape(line);
        drawing.addShape(square);
        GroupCommand group = new GroupCommand(drawing, 0, 1);
        group.execute();
        assertTrue(drawing.getShapes().size() == 1);
    }
    
    /**
     * Test of execute method, of class GroupCommand.
     */
    @Test
    public void testMultipleExecute() {
        Drawing drawing = new Drawing(20, 20);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        Square square = new Square(new Point(5,5), 4, Color.BLUE);
        Square square2 = new Square(new Point(0,0), 5, Color.BLUE);
        drawing.addShape(line);
        drawing.addShape(square);
        drawing.addShape(square2);
        GroupCommand group = new GroupCommand(drawing, 0, 1);
        group.execute();
        group.execute();
        assertTrue(drawing.getShapes().size() == 1);
    }

    /**
     * Test of unexecute method, of class GroupCommand.
     */
    @Test
    public void testUnexecute() {
        Drawing drawing = new Drawing(20, 20);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        Square square = new Square(new Point(5,5), 4, Color.BLUE);
        drawing.addShape(line);
        drawing.addShape(square);
        GroupCommand group = new GroupCommand(drawing, 0, 1);
        group.execute();
        group.unexecute();
        assertTrue(drawing.getShapes().size() == 2);
    }
    
     @Test
    public void testMultipleUnexecute() {
        Drawing drawing = new Drawing(20, 20);
        Line line = new Line(new Point(5,5), new Point(10,10), Color.BLUE);
        Square square = new Square(new Point(5,5), 4, Color.BLUE);
        Square square2 = new Square(new Point(0,0), 5, Color.BLUE);
        drawing.addShape(line);
        drawing.addShape(square);
        drawing.addShape(square2);
        GroupCommand group = new GroupCommand(drawing, 0, 1);
        group.execute();
        group.execute();
        group.unexecute();
        group.unexecute();
        assertTrue(drawing.getShapes().size() == 3);
    }
    
}
