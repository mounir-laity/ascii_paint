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

    public Drawing() {
    }

    public Drawing(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShapeAt(Point p) {
        for (int i = this.shapes.size(); i >= 0; i++) {
            if (shapes.get(i).isInside(p)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

}
