package g53649.AsciiPaint.model;

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

    /**
     * Déplace la forme à l'index donné
     *
     * @param index l'index de la forme à déplacer
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    public void move(int index, int dx, int dy) {
        shapes.get(index).move(dx, dy);
    }

    /**
     * Change la couleur de la forme d'index donné
     *
     * @param index l'index de la forme à recolorer
     * @param color la nouvelle couleur de la forme
     */
    public void changeColor(int index, Color color) {
        shapes.get(index).setColor(color);
    }

    /**
     * Enlève la forme à l'index donné
     *
     * @param index l'index de la forme à enlevr
     */
    public void remove(int index) {
        shapes.remove(index);
    }
    

    /**
     * Getter de la hauteur du canevas
     *
     * @return la hauteur du canevas
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter de la largeur du canevas
     *
     * @return la largeur du canevas
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter de la liste de formes
     * @return la liste de formes
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Converti l'ensemble des formes en une chaine qui les numérote selon leur
     * index
     *
     * @return la chaine de la liste de formes converties
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < shapes.size(); i++) {
            s += i + " : " + shapes.get(i) + '\n';
        }
        return s;
    }

}
