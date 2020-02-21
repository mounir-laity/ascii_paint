package g53649.AsciiPaint.model;

import java.util.Objects;

/**
 *
 * @author laity
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private int width;
    private int height;

    /**
     * Constructeur du rectangle.
     *
     * @param upperLeft le point supérieur gauche du rectangle.
     * @param width la largeur du rectangle.
     * @param height la hauteur du rectangle.
     * @param color la couleur du rectangle.
     * @throws IllegalArgumentException si la hauteur ou la largeur est
     * négative.
     */
    public Rectangle(Point upperLeft, int width, int height, char color) {
        super(color);
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("The width and height must be positive");
        }
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    /**
     * Vérifie qu'un point donné en paramètre appartienne au rectangle.
     *
     * @param p le point à vérifier.
     * @return true si le point se trouve dans la forme, false sinon.
     * @throws NullPointerException si le point est null.
     */
    @Override
    public boolean isInside(Point p) {
        if (p == null) {
            throw new NullPointerException("The point cannot be null");
        }
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
    public void move(int dx, int dy) {
        upperLeft = new Point(upperLeft.getX() + dx, upperLeft.getY() + dy);
    }

    @Override
    public String toString() {
        return "Rectangle : ("+ upperLeft + " " + width + " " + height + ')';
    }

}
