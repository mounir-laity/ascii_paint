package g53649.AsciiPaint.model;

import java.util.Objects;

/**
 *
 * @author laity
 */
public class Line extends ColoredShape {

    private Point p1;
    private Point p2;

    /**
     * Constructeur de Line
     *
     * @param firstPoint le premier point de la ligne
     * @param secondPoint le second point de la ligne
     * @param color la couleur de la ligne
     */
    Line(Point firstPoint, Point secondPoint, Color color) {
        super(color);
        if (firstPoint.equals(secondPoint)) {
            throw new IllegalArgumentException("The two points must be different ");
        }
        this.p1 = firstPoint; // copie.
        this.p2 = secondPoint;
    }

    /**
     * Méthode qui vérifie si un point donné en paramètre appartient à la droite
     *
     * @param p le point à vérifier
     * @return true si ce point appartient à la droite
     */
    @Override
    public boolean isInside(Point p) {
        int i = (p1.getY() - p2.getY()) * p.getX() 
                + (p2.getX() - p1.getX()) * p.getY()
                + p1.getX() * p2.getY() - p2.getX() * p1.getY();
        return i > -5 && i < 5;
    }

    /**
     * Déplace la ligne selon les décalages donnés en paramètres
     *
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    @Override
    public void move(int dx, int dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }

    /**
     * Converti la ligne en chaine
     *
     * @return la chaine correspondante à la ligne
     */
    @Override
    public String toString() {
        return "Line : [" + p1 + " " + p2 + " " + color + ']';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.p1);
        hash = 29 * hash + Objects.hashCode(this.p2);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.p1, other.p1)) {
            return false;
        }
        if (!Objects.equals(this.p2, other.p2)) {
            return false;
        }
        return true;
    }
    
    

}
