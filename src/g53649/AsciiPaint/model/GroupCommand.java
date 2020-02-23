package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class GroupCommand implements Command {

    private final Drawing drawing;
    private final Group group;
    private final int index1;
    private final int index2;

    /**
     * Constructeur de la commande group
     *
     * @param drawing le canevas
     * @param index1 l'index de la première forme à grouper
     * @param index2 l'index de la seconde forme à grouper
     */
    GroupCommand(Drawing drawing, int index1, int index2) {
        this.drawing = drawing;
        this.group = new Group(drawing.getShapes().get(index1).getColor());
        this.index1 = index1;
        this.index2 = index2;
    }

    /**
     * Groupe des formes
     */
    @Override
    public void execute() {
        group.addShape(drawing.getShapes().get(index1));
        group.addShape(drawing.getShapes().get(index2));
        drawing.remove(index2);
        drawing.remove(index1);
        drawing.addShape(group);
    }

    /**
     * Dégroupe des formes
     */
    @Override
    public void unexecute() {
        drawing.getShapes().add(index1, group.getShapes().get(group.getShapes().size() - 2));
        drawing.getShapes().add(index2, group.getShapes().get(group.getShapes().size() - 1));
        drawing.remove(drawing.getShapes().size() - 1);
    }

}
