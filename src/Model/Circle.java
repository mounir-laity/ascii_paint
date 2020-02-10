package Model;

import java.util.Objects;

/**
 *
 * @author laity
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color) {
        super(color);
        if(radius < 0) {
            throw new IllegalArgumentException("The radius must be positive");
        }
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
        if(p == null) {
            throw new NullPointerException("The point cannot be null");
        }
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.center);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(this.center, other.center)) {
            return false;
        }
        return true;
    }
    
    

}
