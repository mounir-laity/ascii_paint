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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
        final Point other = (Point) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

}
