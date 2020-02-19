package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public interface Shape {

    /**
     * Vérifie qu'un point se trouve dans la forme ou non.
     *
     * @param p le point à vérifier.
     * @return true s'il se trouve dans la forme, false sinon.
     */
    boolean isInside(Point p);

    /**
     * Permet de déplacer la forme selon un point de référence.
     *
     * @param dx le décalage horizontal.
     * @param dy le décalage vertical.
     */
    void move(int dx, int dy);

    char getColor();
}
