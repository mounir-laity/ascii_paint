package g53649.AsciiPaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laity
 */
public class ColorCommandTest {

    public ColorCommandTest() {
    }

    /**
     * Test of execute method, of class ColorCommand.
     */
    @Test
    public void testExecute() {
        Line line = new Line(new Point(0, 0), new Point(20, 20), Color.BLUE);
        ColorCommand color = new ColorCommand(line, Color.YELLOW);
        color.execute();
        assertTrue(line.getColor() == Color.YELLOW);
    }
    
    /**
     * Test of execute method, of class ColorCommand.
     */
    @Test
    public void testExecuteWhenSameColor() {
        Line line = new Line(new Point(0, 0), new Point(20, 20), Color.BLUE);
        ColorCommand color = new ColorCommand(line, Color.BLUE);
        color.execute();
        assertTrue(line.getColor() == Color.BLUE);
    }

    /**
     * Test of unexecute method, of class ColorCommand.
     */
    @Test
    public void testUnexecute() {
        Line line = new Line(new Point(0, 0), new Point(20, 20), Color.BLUE);
        ColorCommand color = new ColorCommand(line, Color.YELLOW);
        color.execute();
        color.unexecute();
        assertTrue(line.getColor() == Color.BLUE);

    }
    
    /**
     * Test of execute method, of class ColorCommand.
     */
    @Test
    public void testMultipleExecute() {
        Line line = new Line(new Point(0, 0), new Point(20, 20), Color.BLUE);
        ColorCommand color = new ColorCommand(line, Color.YELLOW);
        ColorCommand color2 = new ColorCommand(line, Color.RED);
        color.execute();
        color2.execute();
        assertTrue(line.getColor() == Color.RED);
    }
    
    /**
     * Test of execute method, of class ColorCommand.
     */
    @Test
    public void testMultipleUnexecute() {
        Line line = new Line(new Point(0, 0), new Point(20, 20), Color.BLUE);
        ColorCommand color = new ColorCommand(line, Color.YELLOW);
        ColorCommand color2 = new ColorCommand(line, Color.RED);
        color.execute();
        color2.execute();
        color.unexecute();
        color2.unexecute();
        assertTrue(line.getColor() == Color.BLUE);
    }

}
