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
public class Group extends ColoredShape {

    private List<Shape> shapes;

    /**
     * Constructeur de group
     *
     * @param color la couleur du groupe
     */
    Group(Color color) {
        super(color);
        this.shapes = new ArrayList<>();
    }

    /**
     * Ajoute une forme à la liste de formes du groupe
     *
     * @param shape la forme à ajouter
     */
    void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Déplace le groupe
     *
     * @param dx le décalage horizontal
     * @param dy le décalage vertical
     */
    @Override
    public void move(int dx, int dy) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).move(dx, dy);
        }
    }

    /**
     * Vérifie si un point se trouve dans une des formes du groupe
     *
     * @param p le point à vérifier
     * @return true s'il s'y trouve, false sinon
     */
    @Override
    public boolean isInside(Point p) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).isInside(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Transforme le groupe en chaine de caractères
     *
     * @return la chaine correspondant au groupe
     */
    @Override
    public String toString() {
        String s = "Group : {";
        for (int i = 0; i < shapes.size(); i++) {
            s += shapes.get(i);
            s += " ; ";
        }
        s += " }";
        return s;
    }

    /**
     * getter de shapes
     *
     * @return la liste de formes du groupe
     */
    List<Shape> getShapes() {
        return shapes;
    }

}
