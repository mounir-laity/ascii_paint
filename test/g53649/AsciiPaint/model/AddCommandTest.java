package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class AddCommandTest {

    public AddCommandTest() {
    }

    Drawing drawing = new Drawing(20, 20);

    /**
     * Test of execute method, of class AddCommand.
     */
    @Test
    public void testExecute() {
        Square square = new Square(new Point(5, 5), 2, Color.BLUE);
        AddCommand instance = new AddCommand(drawing, square);
        instance.execute();
        assertTrue(drawing.getShapes().contains(square));
    }

    /**
     * Test of unexecute method, of class AddCommand.
     */
    @Test
    public void testUnexecute() {
        drawing.getShapes().clear();
        Square square = new Square(new Point(5, 5), 2, Color.BLUE);
        AddCommand instance = new AddCommand(drawing, square);
        instance.execute();
        instance.unexecute();
        assertTrue(drawing.getShapes().isEmpty());
    }

    /**
     * Test of execute method, of class AddCommand.
     */
    @Test
    public void testMultipleExecute() {
        Square square = new Square(new Point(5, 5), 2, Color.BLUE);
        Square square2 = new Square(new Point(0, 0), 2, Color.BLUE);
        AddCommand addSquare = new AddCommand(drawing, square);
        AddCommand addSquare2 = new AddCommand(drawing, square2);
        addSquare.execute();
        addSquare2.execute();
        assertTrue(drawing.getShapes().get(0) == square && drawing.getShapes().get(1) == square2);
    }

    /**
     * Test of unexecute method, of class AddCommand.
     */
    @Test
    public void testMultipleUnexecute() {
        drawing.getShapes().clear();
        Square square = new Square(new Point(5, 5), 2, Color.BLUE);
        Square square2 = new Square(new Point(0, 0), 2, Color.BLUE);
        AddCommand addSquare = new AddCommand(drawing, square);
        AddCommand addSquare2 = new AddCommand(drawing, square2);
        addSquare.execute();
        addSquare2.execute();
        addSquare.unexecute();
        addSquare2.unexecute();
        assertTrue(drawing.getShapes().isEmpty());
    }

}
