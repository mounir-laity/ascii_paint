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

    public void move(double dx, double dy) {
        this.x = x + dx;
        this.y = y + dy;
    }

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
