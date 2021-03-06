package g53649.AsciiPaint.main;

import g53649.AsciiPaint.controller.Controller;
import g53649.AsciiPaint.model.AsciiPaint;
import g53649.AsciiPaint.view.View;

/**
 *
 * @author laity
 */
public class Application {

    private final Controller controller;

    /**
     * Constructeur de l'application
     */
    private Application() {
        AsciiPaint ascii = new AsciiPaint(20, 20);
        View view = new View();
        this.controller = new Controller(ascii, view);
    }

    /**
     * Démarre le programme.
     */
    private void start() {
        controller.interprete();
    }

    /**
     * Méthode main. Elle permet d'ajouter des formes de différentes couleurs et
     * de les montrer.
     *
     * @param args
     */
    public static void main(String[] args) {

        Application app = new Application();
        app.start();
    }
}
