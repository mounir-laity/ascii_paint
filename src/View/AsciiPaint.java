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
    
    public void newCircle(int x, int y, double radius, char color) {
        Point center = new Point(x,y);
        Circle circle = new Circle(center, radius, color);
        drawing.addShape(circle);
    }
    
    public void newRectangle(int x, int y, double width, double height, char color) {
        Point upperLeft = new Point(x,y);
        Rectangle rectangle = new Rectangle(upperLeft, width, height, color);
        drawing.addShape(rectangle);
    }
    
    public void newSquare(int x, int y, double side, char color) {
        Point upperLeft = new Point(x,y);
        Square square = new Square(upperLeft, side, color);
        drawing.addShape(square);
    }
    
    public void asAscii() {
        for(int i = 0; i < drawing.getWidth(); i++) {
            for(int j = 0; j < drawing.getHeight(); j++) {
                if(drawing.getShapeAt(new Point(i, j)) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(drawing.getShapeAt(new Point(i,j)).getColor());
                }
            }
            System.out.print("\n");
        }
    }
}
