package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class Point {

    private int x;
    private int y;

    /**
     * Constructeur du point.
     *
     * @param x l'abcisse du point.
     * @param y l'ordonnée du point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur par copie du point.
     *
     * @param p le point à copier.
     */
    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * Permet de déplacer un point.
     *
     * @param dx le décalage horizontal.
     * @param dy le décalage vertical.
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
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

    /**
     * Getter de la valeur de l'abcisse du point
     *
     * @return l'abcisse du point
     */
    public int getX() {
        return x;
    }

    /**
     * Getter de l'ordonnée du point
     *
     * @return l'ordonnée du point
     */
    public int getY() {
        return y;
    }

    /**
     * Converti le point en chaine de caractères
     *
     * @return la chaine correspondante au point
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

}
