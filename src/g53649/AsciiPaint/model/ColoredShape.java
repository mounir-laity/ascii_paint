package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public abstract class ColoredShape implements Shape {

    protected Color color;

    /**
     * Constructeur de ColoredShape
     *
     * @param color la couleur de la forme.
     */
     ColoredShape(Color color) {
        this.color = color;
    }

    /**
     * getter de la couleur
     *
     * @return la couleur de la forme
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * setter de la couleur
     *
     * @param color la nouvelle couleur de la forme
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

}
