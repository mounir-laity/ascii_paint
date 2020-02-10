package Model;

/**
 *
 * @author laity
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * Permet de déplacer un point.
     *
     * @param dx le décalage horizontal.
     * @param dy le décalage vertical.
     */
    public void move(double dx, double dy) {
        this.x = x + dx;
        this.y = y + dy;
    }

    /**
     * Calcule la distance entre deux points.
     *
     * @param other le point par rapport auquel on cherche la distance.
     * @return la distance entre les deux points.
     */
    public double distanceTo(Point other) {
        return (Math.hypot((other.x - this.x), (other.y - this.y)));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
