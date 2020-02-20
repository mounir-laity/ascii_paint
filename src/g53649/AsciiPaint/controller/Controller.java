package g53649.AsciiPaint.controller;

import g53649.AsciiPaint.model.AsciiPaint;
import g53649.AsciiPaint.view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laity
 */
public class Controller {

    private final AsciiPaint paint;
    private final View view;
    private int pause = 0;

    public Controller(AsciiPaint paint, View view) {
        this.paint = paint;
        this.view = view;
    }

 

    /**
     * Se charge d'interpréter les commandes de l'utilisateur.
     */
    public void interprete() {
        Scanner kb = new Scanner(System.in);
        System.out.println("What would you like to draw ? (type help for help)");
        String command = kb.nextLine();
        while (!"quit".equals(command)) {
            switch (command) {
                case "help":
                    help();
                    command = kb.nextLine();
                    break;
                case "show":
                    paint.asAscii();
                    command = kb.nextLine();
                    break;
                case "list":
                    System.out.println(paint.getDrawing().toString());
                    command = kb.nextLine();
                    break;
                case "load":
                    load();
                    break;
                case "eof":
                    view.reset();
                    command = kb.nextLine();
                    break;

//                case "pause":
//                    pause = Integer.parseInt(elements[1]);
//                    break;
                default:
                    verify(command);
                    command = kb.nextLine();
                    break;
            }
        }
        System.exit(0);
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
        interprete();
    }

    /**
     * Vérifie que la commande entrée pour créer une forme soit sous la bonne
     * forme.
     *
     * @param command la ligne entrée par l'utilisateur.
     */
    public void verify(String command) {
        if (command.matches("add circle ([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20)"
                + " ([0-9]|1[0-9]|20) \\w")) {
            tokenizeCircle(command);
        } else if (command.matches("add rectangle ([0-9]|1[0-9]|20) "
                + "([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20) \\w")) {
            tokenizeRectangle(command);
        } else if (command.matches("add square ([0-9]|1[0-9]|20)"
                + " ([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20) \\w")) {
            tokenizeSquare(command);
        } else if (command.matches("add line ([0-9]|1[0-9]|20)"
                + " ([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20) ([0-9]|1[0-9]|20) \\w")) {
            tokenizeLine(command);
        } else {
            System.out.println("Incorrect format. Type help for the list of "
                    + "valid commands");
        }
        interprete();
    }

    /**
     * Gère la création d'un cercle en extrayant les paramètres de la commande
     * de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    public void tokenizeCircle(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newCircle(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }

    /**
     * Gère la création d'un rectangle en extrayant les paramètres de la
     * commande de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    public void tokenizeRectangle(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newRectangle(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }

    /**
     * Gère la création d'un carré en extrayant les paramètres de la commande de
     * l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    public void tokenizeSquare(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newSquare(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }

    /**
     * Gère la création d'une droite en extrayant les paramètres de la commande
     * de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    public void tokenizeLine(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newLine(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }

    public void pause() throws InterruptedException {
        Thread.sleep(pause);
    }

    private void load() {
        try {
            view.setInput(new FileInputStream("dessin"));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPause(int pause) {
        this.pause = pause;
    }
}
