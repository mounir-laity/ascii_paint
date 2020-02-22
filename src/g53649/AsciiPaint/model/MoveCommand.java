package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class MoveCommand implements Command {

    private Shape shape;
    private int dx;
    private int dy;

    public MoveCommand(Shape shape, int dx, int dy) {
        this.shape = shape;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        shape.move(dx, dy);
    }

    @Override
    public void unexecute() {
        shape.move(-dx, -dy);
    }

}
