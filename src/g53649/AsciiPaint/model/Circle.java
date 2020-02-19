package g53649.AsciiPaint.model;

import java.util.Objects;

/**
 *
 * @author laity
 */
public class Circle extends ColoredShape {

    private Point center;
    private int radius;

    /**
     * Constructeur du cercle.
     *
     * @param center le centre du cercle.
     * @param radius le rayon du cercle.
     * @param color la couleur du cercle.
     * @throws IllegalArgumentException si le rayon est négatif.
     */
    public Circle(Point center, int radius, char color) {
        super(color);
        if (radius < 0) {
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
     * @throws NullPointerException si le point en paramètre est null.
     */
    @Override
    public boolean isInside(Point p) {
        if (p == null) {
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
    public void move(int dx, int dy) {
        center = new Point(center.getX() + dx, center.getY() + dy);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(center);
        hash = 61 * hash + (int) (Double.doubleToLongBits(radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(center, other.center)) {
            return false;
        }
        return true;
    }

}
