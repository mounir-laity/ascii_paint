package g53649.AsciiPaint.model;

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
    public Line(Point firstPoint, Point secondPoint, Color color) {
        super(color);
        if (firstPoint.equals(secondPoint)) {
            throw new IllegalArgumentException("The two points must be different ");
        }
        this.p1 = firstPoint;
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
        int i = (p1.getY() - p2.getY()) * p.getX() + (p2.getX() - p1.getX()) * p.getY()
                + p1.getX() * p2.getY() - p2.getX() * p1.getY();
        return i > -1 && i < 1;
    }

    /**
     * Déplace la ligne selon les décalages donnés en paramètres
     *
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    @Override
    public void move(int dx, int dy) {
        p1 = new Point(p1.getX() + dx, p1.getY() + dy);
        p2 = new Point(p2.getX() + dx, p2.getY() + dy);
    }

    /**
     * Converti la ligne en chaine
     *
     * @return la chaine correspondante à la ligne
     */
    @Override
    public String toString() {
        return "Line : [" + p1 + " " + p2 + ']';
    }

}
