package g53649.AsciiPaint.model;

/**
 * Les couleurs ont la forme [Code couleur] caractère [reset de la couleur]
 *
 * @author laity
 */
public enum Color {
    RED("\u001B[41m" + " " + "\033[0m"), BLUE("\033[0;44m" + ' ' + "\033[0m"), // dans la vue.
    GREEN("\033[0;42m" + ' ' + "\033[0m"), YELLOW("\033[0;43m" + ' ' + "\033[0m"),
    CYAN("\033[0;46m" + ' ' + "\033[0m"), MAGENTA("\033[0;45m" + ' ' + "\033[0m"),
    DEFAULT("\u001B[30m" + 'o' + "\033[0m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}
