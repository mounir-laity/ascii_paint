/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53649.AsciiPaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laity
 */
public class Group extends ColoredShape{

    private List<Shape> shapes;

    public Group(Color color) {
        super(color);
        this.shapes = new ArrayList<>();
    }

    

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (int i = 0; i < shapes.size(); i++) {
        shapes.get(i).move(dx, dy);
    }
    }

    @Override
    public boolean isInside(Point p) {
        for(int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i).isInside(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Group : {";
        for(int i = 0; i < shapes.size(); i++) {
            s += shapes.get(i);
            s += " ; ";
        }
        s += " }";
        return s;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
    
    
    
    
}
