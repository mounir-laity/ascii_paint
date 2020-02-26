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
    Circle(Point center, int radius, Color color) {
        super(color);
        if (radius <= 0) {
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

    /**
     * Transforme l'objet cercle en chaine de caractères
     *
     * @return la chaine correspondant à l'objet
     */
    @Override
    public String toString() {
        return "Circle : [" + center + " " + radius + " " + color + ']';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.center);
        hash = 59 * hash + this.radius;
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
        if (!(obj instanceof Circle)) {
            return false;
        }
        final Circle other = (Circle) obj;
        if (this.radius != other.radius) {
            return false;
        }
        return Objects.equals(this.center, other.center);
    }

   
    
    

}
