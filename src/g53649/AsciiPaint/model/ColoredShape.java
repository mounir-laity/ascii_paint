package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public abstract class ColoredShape implements Shape {

    private Color color;

    /**
     * Constructeur de ColoredShape
     *
     * @param color la couleur de la forme.
     */
    public ColoredShape(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

}
