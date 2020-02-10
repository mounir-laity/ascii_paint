package View;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author laity
 */
public class AsciiPaint {

    private Drawing drawing;

    public AsciiPaint() {
    }

    public AsciiPaint(int width, int height) {
        drawing = new Drawing(width, height);
    }

    /**
     * Crée un nouveau cercle avec les valeurs entrées en paramètres.
     *
     * @param x l'abcisse du centre du cercle.
     * @param y l'ordonnée du centre du cercle.
     * @param radius le rayon du cercle.
     * @param color la couleur du cercle.
     */
    public void newCircle(int x, int y, double radius, char color) {
        Point center = new Point(x, y);
        Circle circle = new Circle(center, radius, color);
        drawing.addShape(circle);
    }

    /**
     * Crée un nouveau rectangle avec les valeurs entrées en paramètres.
     *
     * @param x l'abcisse du point supérieur gauche du rectangle.
     * @param y l'ordonnée du point supérieur gauche du rectangle.
     * @param width la largeur du rectangle.
     * @param height la hauteur du rectangle.
     * @param color la couleur du rectangle.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        Point upperLeft = new Point(x, y);
        Rectangle rectangle = new Rectangle(upperLeft, width, height, color);
        drawing.addShape(rectangle);
    }

    /**
     * Crée un nouveau carré avec les valeurs entrées en paramètres.
     *
     * @param x l'abcisse du point supérieur gauche du carré.
     * @param y l'ordonnée du point supérieur gauche du carré.
     * @param side le côté du carré.
     * @param color la couleur du carré.
     */
    public void newSquare(int x, int y, double side, char color) {
        Point upperLeft = new Point(x, y);
        Square square = new Square(upperLeft, side, color);
        drawing.addShape(square);
    }

    /**
     * Permet de représenter sur l'output les différentes formes ajoutées par
     * l'utilisateur.
     */
    public void asAscii() {
        for (int i = 0; i < drawing.getWidth(); i++) {
            for (int j = 0; j < drawing.getHeight(); j++) {
                if (drawing.getShapeAt(new Point(i, j)) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(drawing.getShapeAt(new Point(i, j)).getColor());
                }
            }
            System.out.print("\n");
        }
    }
}
