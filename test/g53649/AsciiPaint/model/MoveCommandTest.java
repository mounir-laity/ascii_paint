package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class MoveCommandTest {
    
    public MoveCommandTest() {
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecute() {
        Circle circle = new Circle(new Point(0, 0), 5, Color.BLUE);
        Circle expected = new Circle(new Point(5, 5), 5, Color.BLUE);
        MoveCommand move = new MoveCommand(circle, 5, 5);
        move.execute();
        assertEquals(expected, circle);
        
    }
    
    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testMultipleExecute() {
        Circle circle = new Circle(new Point(0, 0), 5, Color.BLUE);
        Circle expected = new Circle(new Point(10, 10), 5, Color.BLUE);
        MoveCommand move = new MoveCommand(circle, 5, 5);
        move.execute();
        move.execute();
        assertEquals(expected, circle);
        
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecute() {
        Circle circle = new Circle(new Point(0, 0), 5, Color.BLUE);
        Circle expected = new Circle(new Point(0, 0), 5, Color.BLUE);
        MoveCommand move = new MoveCommand(circle, 5, 5);
        move.execute();
        move.unexecute();
        assertEquals(expected, circle);
    }
    
    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testMultipleUnexecute() {
        Circle circle = new Circle(new Point(0, 0), 5, Color.BLUE);
        Circle expected = new Circle(new Point(0, 0), 5, Color.BLUE);
        MoveCommand move = new MoveCommand(circle, 5, 5);
        move.execute();
        move.execute();
        move.unexecute();
        move.unexecute();
        assertEquals(expected, circle);
    }
    
}
