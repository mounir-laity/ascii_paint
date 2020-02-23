package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class ColorCommand implements Command {

    private final Shape shape;
    private final Color oldColor;
    private final Color newColor;

    ColorCommand(Shape shape, Color newColor) {
        this.shape = shape;
        this.oldColor = shape.getColor();
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        shape.setColor(newColor);
    }

    @Override
    public void unexecute() {
        shape.setColor(oldColor);
    }

}
