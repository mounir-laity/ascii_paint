package g53649.AsciiPaint.view;

import g53649.AsciiPaint.model.Drawing;
import g53649.AsciiPaint.model.Point;
import java.io.IOException;
import java.io.InputStream;
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
    
    
    public void setInput() {
        try {
            kb = new Scanner(Paths.get("dessin.txt"));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reset() {
        kb = new Scanner(System.in);
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
        System.out.println("show");
        System.out.println("");
    }

    public Scanner getKb() {
        return kb;
    }
    
    /**
     * Permet de représenter sur l'output les différentes formes ajoutées par
     * l'utilisateur.
     */
    public void asAscii(Drawing drawing) {
        for (int i = 0; i < drawing.getWidth(); i++) {
            for (int j = 0; j < drawing.getHeight(); j++) {
                if (drawing.getShapeAt(new Point(i, j)) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(drawing.getShapeAt(new Point(i, j)).getColor());
                }
            }
            System.out.print("\n");
        }
    }
}
