package Model;

/**
 *
 * @author laity
 */
public interface Shape {
    boolean isInside(Point p);
    void move(double dx, double dy);
    char getColor();
}
