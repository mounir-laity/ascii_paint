package g53649.AsciiPaint.model;

/**
 *
 * @author g53649
 */
public class AddCommand implements Command {

    private Drawing drawing;
    private Shape shape;

    /**
     * Constructeur de AddCommand
     *
     * @param drawing
     * @param shape
     */
    public AddCommand(Drawing drawing, Shape shape) {
        this.drawing = drawing;
        this.shape = shape;
    }

    @Override
    public void execute() {
        drawing.addShape(shape);
    }

    @Override
    public void unexecute() {
        drawing.remove(drawing.getShapes().size()-1);
    }

}
