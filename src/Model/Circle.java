package Model;

/**
 *
 * @author laity
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color) {
        super(color);
        this.center = new Point(center);
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point p) {
        return p.distanceTo(center) <= radius;
    }

    @Override
    public void move(double dx, double dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    public Point getCenter() {
        return new Point(center);
    }

    public double getRadius() {
        return radius;
    }

}
