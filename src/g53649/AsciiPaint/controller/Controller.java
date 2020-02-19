package g53649.AsciiPaint.controller;

import g53649.AsciiPaint.model.AsciiPaint;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author laity
 */
public class Controller {

    private final AsciiPaint paint;

    public Controller() {
        this.paint = new AsciiPaint(20, 20);
    }

    /**
     * Se charge d'interpréter les commandes de l'utilisateur.
     */
    public void interprete() {
        Scanner kb = new Scanner(System.in);
        System.out.println("What would you like to draw ? (type help for help)");
        String command = kb.nextLine();
        while (!"equals".equals(command)) {
            if (command.equals("help")) {
                help();
                command = kb.nextLine();
            } else if (command.equals("show")){
                paint.asAscii();
                command = kb.nextLine();
            } else if (command.equals("list")){
                System.out.println(paint.getDrawing().toString());
                command = kb.nextLine();
            } else {
                verify(command);
                command = kb.nextLine();
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
     * Gère la création d'une droite en extrayant les paramètres de la commande de
     * l'utilisateur.
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
}
