package g53649.AsciiPaint.controller;

import g53649.AsciiPaint.model.AsciiPaint;
import g53649.AsciiPaint.view.View;
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
        System.out.println("Entrez vos commandes (help affiche la liste des commandes)");
        String command = view.ask();
        while (!"quit".equals(command)) {
            try {
                pause();
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            StringTokenizer tokens = new StringTokenizer(command);
            switch (tokens.nextToken()) {
                case "help":
                    view.help();
                    command = view.ask();
                    break;
                case "show":
                    view.asAscii(paint.getDrawing());
                    command = view.ask();
                    break;
                case "list":
                    System.out.println(paint.getDrawing().toString());
                    command = view.ask();
                    break;
                case "load":
                    load();
                    command = view.ask();
                    break;
                case "eof":
                    view.reset();
                    command = view.ask();
                    break;

                case "pause":
                    pause = Integer.parseInt(tokens.nextToken());
                    command = view.ask();
                    break;

                default:
                    verify(command);
                    command = view.ask();
                    break;
            }
        }
        System.exit(0);
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
        view.setInput();
    }

    public void setPause(int pause) {
        this.pause = pause;
    }
}
