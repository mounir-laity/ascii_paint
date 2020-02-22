package g53649.AsciiPaint.model;

/**
 *
 * @author g53649
 */
public interface Command {

    /**
     * Exécute la commande
     */
    void execute();

    /**
     * Annule la commande
     */
    void unexecute();
}
