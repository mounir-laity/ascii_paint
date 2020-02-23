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
                case "group":
                    paint.newGroup(Integer.parseInt(tokens.nextToken()),
                            Integer.parseInt(tokens.nextToken()));
                    command = view.ask();
                    break;
                case "move":
                    paint.move(Integer.parseInt(tokens.nextToken()),
                            Integer.parseInt(tokens.nextToken()),
                            Integer.parseInt(tokens.nextToken()));
                    command = view.ask();
                    break;
                case "color":
                    paint.color(Integer.parseInt(tokens.nextToken()),
                            paint.convertToColor(command.charAt(command.length() - 1)));
                    command = view.ask();
                    break;
                case "load":
                    load();
                    command = view.ask();
                    break;
                case "remove":
                    paint.getDrawing().remove(Integer.parseInt(tokens.nextToken()));
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
                case "undo":
                    paint.undo();
                    command = view.ask();
                    break;
                case "redo":
                    paint.redo();
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
    private void verify(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        switch (tokens.nextToken()) {
            case "circle":
                tokenizeCircle(command);
                break;
            case "rectangle":
                tokenizeRectangle(command);
                break;
            case "square":
                tokenizeSquare(command);
                break;
            case "line":
                tokenizeLine(command);
                break;
            default:
                System.out.println("Incorrect format. Type help for the list of commands");
                break;
        }
    }

    /**
     * Gère la création d'un cercle en extrayant les paramètres de la commande
     * de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    private void tokenizeCircle(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newCircle(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                paint.convertToColor(command.charAt(command.length() - 1)));
    }

    /**
     * Gère la création d'un rectangle en extrayant les paramètres de la
     * commande de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    private void tokenizeRectangle(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newRectangle(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                paint.convertToColor(command.charAt(command.length() - 1)));
    }

    /**
     * Gère la création d'un carré en extrayant les paramètres de la commande de
     * l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    private void tokenizeSquare(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newSquare(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                paint.convertToColor(command.charAt(command.length() - 1)));
    }

    /**
     * Gère la création d'une droite en extrayant les paramètres de la commande
     * de l'utilisateur.
     *
     * @param command la commande donnée par l'utilisateur.
     */
    private void tokenizeLine(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newLine(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                paint.convertToColor(command.charAt(command.length() - 1)));
    }

    /**
     * Met en pause le programme après chaque commande
     *
     * @throws InterruptedException l'interruption causée par la pause
     */
    private void pause() throws InterruptedException {
        Thread.sleep(pause);
    }

    /**
     * Permet d'utiliser un fichier comme entrée pour les commandes
     */
    private void load() {
        view.setInput();
    }
}
