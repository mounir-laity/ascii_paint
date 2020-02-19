package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Constructeur de ColoredShape
     *
     * @param color la couleur de la forme.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + color;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColoredShape other = (ColoredShape) obj;
        if (color != other.color) {
            return false;
        }
        return true;
    }

}
