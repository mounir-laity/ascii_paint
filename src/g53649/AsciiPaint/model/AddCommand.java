package g53649.AsciiPaint.model;

/**
 *
 * @author g53649
 */
public class AddCommand implements Command {

    private final Drawing drawing;
    private final Shape shape;

    /**
     * Constructeur de AddCommand
     *
     * @param drawing
     * @param shape
     */
    AddCommand(Drawing drawing, Shape shape) {
        this.drawing = drawing;
        this.shape = shape;
    }

    /**
     * Ajoute une forme au canevas
     */
    @Override
    public void execute() {
        drawing.addShape(shape);
    }

    /**
     * Enlève une forme du canevas
     */
    @Override
    public void unexecute() {
        drawing.remove(drawing.getShapes().size() - 1);
    }

}
