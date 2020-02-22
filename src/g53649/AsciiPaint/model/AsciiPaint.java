package g53649.AsciiPaint.model;

import java.util.Stack;

/**
 *
 * @author laity
 */
public class AsciiPaint {

    private final Drawing drawing;
    private final Stack<Command> undostack;

    /**
     * Constructeur d'AsciiPaint
     *
     * @param width la largeur du canvas.
     * @param height la hauteur du canvas.
     */
    public AsciiPaint(int width, int height) {
        drawing = new Drawing(width, height);
        undostack = new Stack<>();
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
        undostack.push(add);
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
        Command add = new AddCommand(drawing, new Rectangle(new Point(x, y), width, height, color));
        add.execute();
        undostack.push(add);
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
        Command add = new AddCommand(drawing, new Square(new Point(x, y), side, color));
        add.execute();
        undostack.push(add);
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
        Command add = new AddCommand(drawing, new Line(new Point(p1x, p1y), new Point(p2x,p2y), color));
        add.execute();
        undostack.push(add);
    }
    
    public void newGroup(int index1, int index2) {
        Group group = new Group(drawing.getShapes().get(index1).getColor());
        group.addShape(drawing.getShapes().get(index1));
        group.addShape(drawing.getShapes().get(index2));
        drawing.addShape(group);
        drawing.getShapes().remove(drawing.getShapes().get(index1));
        drawing.getShapes().remove(drawing.getShapes().get(index2-1));
    }
    
    public void move(int index, int dx, int dy) {
        Command move = new MoveCommand(drawing.getShapes().get(index), dx, dy);
        move.execute();
        undostack.push(move);
    }
    
    public void color(int index, Color color) {
        Command changeColor = new ColorCommand(drawing.getShapes().get(index), color);
        changeColor.execute();
        undostack.push(changeColor);
    }

    /**
     * Permet de convertir un caractère en couleur correspondante
     *
     * @param c le caractère à convertir
     * @return la couleur correspondant au caractère entré (bleu par défaut)
     */
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
        return Color.DEFAULT;
    }
    
    //////////////////////////////////////////////
    public void undo() {
        undostack.pop().unexecute();
    }

    /**
     * Getter de drawing
     *
     * @return le canevas où sont placées les formes
     */
    public Drawing getDrawing() {
        return drawing;
    }

}
