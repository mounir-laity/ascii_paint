package Controller;

import View.AsciiPaint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author laity
 */
public class Controller {

    private AsciiPaint paint;

    public Controller() {
        this.paint = new AsciiPaint(20, 20);
    }

    public void interprete() {
        Scanner kb = new Scanner(System.in);
        System.out.println("What would you like to draw ? (type help for help)");
        String command = kb.nextLine();
        if (command.equals("show")) {
            paint.asAscii();
        } else if (command.equals("exit")) {
            System.exit(0);
        } else if (command.equals("help")) {
            help();
        } else {
            verify(command);
        }
    }

    public void help() {
        System.out.println("Here's the list of all other possible commands : ");
        System.out.println("exit - quits the program");
        System.out.println("add circle x y radius color");
        System.out.println("add rectangle x y width height color");
        System.out.println("add square x y side color");
        System.out.println("show");
        System.out.println("");
        interprete();
    }

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
        } else {
            System.out.println("Incorrect format");
        }
        interprete();
    }

    public void tokenizeCircle(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newCircle(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }

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

    public void tokenizeSquare(String command) {
        StringTokenizer tokens = new StringTokenizer(command);
        tokens.nextToken();
        tokens.nextToken();
        paint.newSquare(Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                Integer.parseInt(tokens.nextToken()),
                command.charAt(command.length() - 1));
    }
}
