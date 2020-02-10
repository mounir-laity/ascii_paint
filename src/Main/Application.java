package Main;

import Controller.Controller;

/**
 *
 * @author laity
 */
public class Application {

    private final Controller controller = new Controller();

    /**
     * Démarre le programme.
     */
    public void start() {
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
