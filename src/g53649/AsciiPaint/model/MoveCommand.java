package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class MoveCommand implements Command {

    private final Shape shape;
    private final int dx;
    private final int dy;

    /**
     * Constructeur de la commande move
     *
     * @param shape la forme à déplacer
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    MoveCommand(Shape shape, int dx, int dy) {
        this.shape = shape;
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Déplace la forme
     */
    @Override
    public void execute() {
        shape.move(dx, dy);
    }

    /**
     * Annule le déplacement
     */
    @Override
    public void unexecute() {
        shape.move(-dx, -dy);
    }

}
