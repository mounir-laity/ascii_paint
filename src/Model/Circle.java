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

    /**
     * Vérifie qu'un point donné en paramètre appartienne au cercle.
     *
     * @param p le point à vérifier.
     * @return true si le point se trouve dans la forme, false sinon.
     */
    @Override
    public boolean isInside(Point p) {
        return p.distanceTo(center) <= radius;
    }

    /**
     * Permet de déplacer le cercle selon son centre.
     *
     * @param dx le décalage horizontal.
     * @param dy le décalage vertical.
     */
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
