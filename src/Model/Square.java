package Model;

/**
 *
 * @author laity
 */
public class Square extends Rectangle {

    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
        if(side < 0) {
            throw new IllegalArgumentException("The side must be positive");
        }
    }

}
