package g53649.AsciiPaint.model;

import java.util.Stack;

/**
 *
 * @author laity
 */
public class AsciiPaint {

    private final Drawing drawing;
    private final Stack<Command> undostack;
    private final Stack<Command> redostack;

    /**
     * Constructeur d'AsciiPaint
     *
     * @param width la largeur du canvas.
     * @param height la hauteur du canvas.
     */
    public AsciiPaint(int width, int height) {
        // on vérifier les params.
        drawing = new Drawing(width, height);
        undostack = new Stack<>();
        redostack = new Stack<>();
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
        // dans la facade on vérfiie les params: rien de pourri ne doit rentrer dans le modèle
        Command add = new AddCommand(drawing, new Circle(new Point(x, y), radius, color));
        add.execute();
        undostack.push(add);
        // clear redo stack.
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
        // clear redo
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
        Command add = new AddCommand(drawing, new Line(new Point(p1x, p1y), new Point(p2x, p2y), color));
        add.execute();
        undostack.push(add);
    }

    /**
     * Crée un nouveau groupe de formes
     *
     * @param index1 l'index de la première forme du groupe
     * @param index2 l'index de la seconde forme du groupe
     */
    public void newGroup(int index1, int index2) {
        GroupCommand group = new GroupCommand(drawing, index1, index2);
        group.execute();
        undostack.push(group);
    }

    /**
     * Déplace une forme d'indice donné selon les décalages donnés
     *
     * @param index l'index de la forme à déplacer
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    public void move(int index, int dx, int dy) {
        Command move = new MoveCommand(drawing.getShapes().get(index), dx, dy);
        move.execute();
        undostack.push(move);
    }

    /**
     * Colorie une forme
     *
     * @param index l'index de la forme à colorier
     * @param color la nouvelle couleur de la forme
     */
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
    public Color convertToColor(char c) { // dans le controller.
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

    /**
     * Annule la dernière commande entrée par l'utilisateur
     */
    public void undo() {
        if (undostack.isEmpty()) {
            System.out.println("No action to undo");
        } else {
            undostack.peek().unexecute();
            redostack.push(undostack.pop());
        }
    }

    /**
     * Refait la dernière commande annulée
     */
    public void redo() {
        if (redostack.isEmpty()) {
            System.out.println("No action to redo");
        } else {
            redostack.peek().execute();
            undostack.push(redostack.pop());
        }
    }

    /**
     * Getter de drawing
     *
     * @return le canevas où sont placées les formes
     */
    public Drawing getDrawing() { // bof.
        return drawing;
    }

}
