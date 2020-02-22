package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public class GroupCommand implements Command{

    private Drawing drawing;
    private Group group;
    private int index1;
    private int index2;

    public GroupCommand(Drawing drawing, int index1, int index2) {
        this.drawing = drawing;
        this.group = new Group(drawing.getShapes().get(index1).getColor());
        this.index1 = index1;
        this.index2 = index2;
    }
    
    
    @Override
    public void execute() {
        group.addShape(drawing.getShapes().get(index1));
        group.addShape(drawing.getShapes().get(index2));
        drawing.remove(index2);
        drawing.remove(index1);
        drawing.addShape(group);
    }

    @Override
    public void unexecute() {
        drawing.getShapes().add(index1, group.getShapes().get(group.getShapes().size()-2));
        drawing.getShapes().add(index2, group.getShapes().get(group.getShapes().size()-1));
        drawing.remove(drawing.getShapes().size()-1);
    }
    
}
