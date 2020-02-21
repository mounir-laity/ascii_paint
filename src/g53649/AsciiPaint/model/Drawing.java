package g53649.AsciiPaint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author laity
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Constructeur de Drawing.
     *
     * @param height la hauteur du canvas.
     * @param width la largeur du canvas.
     * @throws IllegalArgumentException si au moins un des paramètres est
     * négatif.
     */
    public Drawing(int height, int width) {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("The height and width must be positive");
        }
        this.height = height;
        this.width = width;
        shapes = new ArrayList<>();
    }

    /**
     * Permet d'ajouter une forme à la liste de formes que Drawing possède.
     *
     * @param shape la forme à ajouter.
     * @throws NullPointerException si la forme est null.
     */
    public void addShape(Shape shape) {
        if (shape == null) {
            throw new NullPointerException("The shape cannot be null");
        }
        shapes.add(shape);
    }

    /**
     * Cherche la dernière forme de la liste contenant le point en paramètre.
     *
     * @param p le point auquel on cherche la forme correspondante.
     * @return la dernière forme de la liste contenant le point en paramètre ou
     * null s'il n'y en a pas.
     * @throws NullPointerException si le point est null.
     */
    public Shape getShapeAt(Point p) {
        if (p == null) {
            throw new NullPointerException("The point cannot be null");
        }
        for (int i = this.shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).isInside(p)) {
                return shapes.get(i);
            }
        }
        return null;
    }
    
    public void move(int index, int dx, int dy) {
        shapes.get(index).move(dx, dy);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public void remove(int index) {
        shapes.remove(index);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < shapes.size(); i++) {
            s += i + " : " + shapes.get(i) + '\n';
        }
        return s;
    }

}
