package Model;

/**
 *
 * @author laity
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    /**
     * Vérifie qu'un point donné en paramètre appartienne au rectangle.
     *
     * @param p le point à vérifier.
     * @return true si le point se trouve dans la forme, false sinon.
     */
    @Override
    public boolean isInside(Point p) {
        return !(p.getX() < upperLeft.getX() || p.getY() < upperLeft.getY()
                || p.getX() > upperLeft.getX() + width
                || p.getY() > upperLeft.getY() + height);
    }

    /**
     * Permet de déplacer le rectangle selon son point supérieur gauche.
     *
     * @param dx le décalage horizontal.
     * @param dy le décalage vertical.
     */
    @Override
    public void move(double dx, double dy) {
        this.upperLeft = new Point(upperLeft.getX() + dx, upperLeft.getY() + dy);
    }
}
