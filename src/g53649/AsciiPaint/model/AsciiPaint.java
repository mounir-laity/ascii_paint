package g53649.AsciiPaint.model;

import java.util.Stack;

/**
 *
 * @author laity
 */
public class AsciiPaint {

    private Drawing drawing;
    private Stack<Command> stack;

    /**
     * Constructeur d'AsciiPaint
     *
     * @param width la largeur du canvas.
     * @param height la hauteur du canvas.
     */
    public AsciiPaint(int width, int height) {
        drawing = new Drawing(width, height);
        stack = new Stack<>();
    }

    /**
     * Crée un nouveau cercle avec les valeurs entrées en paramètres.
     *
     * @param x l'abcisse du centre du cercle.
     * @param y l'ordonnée du centre du cercle.
     * @param radius le rayon du cercle.
     * @param color la couleur du cercle.
     */
    public void newCircle(int x, int y, int radius, Color color) {
        Command add = new AddCommand(drawing, new Circle(new Point(x, y), radius, color));
        add.execute();
        stack.add(add);
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
    public void newRectangle(int x, int y, int width, int height, Color color) {
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
    public void newSquare(int x, int y, int side, Color color) {
        Point upperLeft = new Point(x, y);
        Square square = new Square(upperLeft, side, color);
        drawing.addShape(square);
    }

    /**
     * Crée une nouvelle droite avec les valeurs entrées en paramètres.
     *
     * @param p1x l'abcisse du premier point de la droite.
     * @param p1y l'ordonnée du premier point de la droite.
     * @param p2x l'abcisse du second point de la droite.
     * @param p2y l'ordonnée du second point de la droite.
     * @param color la couleur de la droite
     */
    public void newLine(int p1x, int p1y, int p2x, int p2y, Color color) {
        Point p1 = new Point(p1x, p1y);
        Point p2 = new Point(p2x, p2y);
        Line line = new Line(p1, p2, color);
        drawing.addShape(line);
    }
    
    public Color convertToColor(char c) {
        switch (c) {
            case 'r':
                return Color.RED;
            case 'b':
                return Color.BLUE;
            case 'm':
                return Color.MAGENTA;
            case 'g':
                return Color.GREEN;
            case 'y':
                return Color.YELLOW;
            case 'c':
                return Color.CYAN;
            default:
                break;
        }
        return Color.BLUE;
    }

    public Drawing getDrawing() {
        return drawing;
    }

}
