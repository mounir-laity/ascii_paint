package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class Square extends Rectangle {

    /**
     * Constructeur du carré.
     *
     * @param upperLeft le point supérieur gauche du carré.
     * @param side le côté du carré.
     * @param color la couleur du carré.
     * @throws IllegalArgumentException si le côté est négatif.
     */
     Square(Point upperLeft, int side, Color color) {
        super(upperLeft, side, side, color);
        if (side <= 0) {
            throw new IllegalArgumentException("The side must be positive");
        }
    }

}
