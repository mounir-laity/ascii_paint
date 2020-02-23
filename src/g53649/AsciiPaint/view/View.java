package g53649.AsciiPaint.view;

import g53649.AsciiPaint.model.Drawing;
import g53649.AsciiPaint.model.Point;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laity
 */
public class View {

    private Scanner kb = new Scanner(System.in);

    /**
     * Change l'entrée du clavier vers le fichier dessin.txt en racine du projet
     */
    public void setInput() {
        try {
            kb = new Scanner(Paths.get("dessin.txt"));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Réinitialise l'entrée vers le clavier
     */
    public void reset() {
        kb = new Scanner(System.in);
    }

    /**
     * Permet à l'utilisateur d'entrer une commande
     *
     * @return la commande entrée par l'utilisateur
     */
    public String ask() {
        String command = kb.nextLine();
        return command;
    }

    /**
     * Indique à l'utilisateur quelles sont les commandes possibles.
     */
    public void help() {
        System.out.println("Here's the list of all other possible commands : ");
        System.out.println("add circle x y radius color");
        System.out.println("add rectangle x y width height color");
        System.out.println("add square x y side color");
        System.out.println("add line x1 y1 x2 y2 color");
        System.out.println("color index <color>");
        System.out.println("group index1 index2");
        System.out.println("help");
        System.out.println("list");
        System.out.println("load");
        System.out.println("move dx dy");
        System.out.println("pause x");
        System.out.println("remove index");
        System.out.println("show");
        System.out.println("undo");
        System.out.println("redo");
        System.out.println("quit");
        System.out.println("");
    }

    /**
     * Permet de représenter sur l'output les différentes formes ajoutées par
     * l'utilisateur.
     *
     * @param drawing le canevas à remplir
     */
    public void asAscii(Drawing drawing) {
        for (int i = 0; i < drawing.getWidth(); i++) {
            for (int j = 0; j < drawing.getHeight(); j++) {
                if (drawing.getShapeAt(new Point(i, j)) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(drawing.getShapeAt(new Point(i, j)).getColor().toString());
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * getter du scanner
     *
     * @return le scanner
     */
    Scanner getKb() {
        return kb;
    }

}
