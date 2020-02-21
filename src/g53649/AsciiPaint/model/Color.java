package g53649.AsciiPaint.model;

/**
 *
 * @author laity
 */
public enum Color {
   RED("\033[0;31m" +'r'+ "\033[0m"), BLUE("\033[0;34m" +'b'+ "\033[0m"), 
   GREEN("\033[0;32m" +'g' +"\033[0m"), YELLOW("\033[0;33m" +'y' +"\033[0m"),
    CYAN("\033[0;36m" +'c'+ "\033[0m"), MAGENTA("\033[0;35m" +'m'+ "\033[0m");
   
   private final String code;
   Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
   
}
