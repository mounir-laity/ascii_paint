package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laity
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    public Drawing(int height, int width) {
        this.height = height;
        this.width = width;
        shapes = new ArrayList<>();
    }

    /**
     * Permet d'ajouter une forme à la liste de formes que Drawing possède.
     *
     * @param shape la forme à ajouter.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Cherche la dernière forme de la liste contenant le point en paramètre.
     *
     * @param p le point auquel on cherche la forme correspondante.
     * @return la dernière forme de la liste contenant le point en paramètre ou
     * null s'il n'y en a pas.
     */
    public Shape getShapeAt(Point p) {
        for (int i = this.shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).isInside(p)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
