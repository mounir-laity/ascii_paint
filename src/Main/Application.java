package Main;

import Controller.Controller;

/**
 *
 * @author laity
 */
public class Application {
    private Controller controller = new Controller();
    
    public void start() {
        controller.interprete();
    }
    

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
