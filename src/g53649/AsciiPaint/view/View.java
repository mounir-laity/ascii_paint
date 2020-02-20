package g53649.AsciiPaint.view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laity
 */
public class View {
    private Scanner kb = new Scanner(System.in);
    
    public void setInput(InputStream in) {
        try {
            this.kb = new Scanner(Paths.get(".//dessin"));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reset() {
        kb = new Scanner(System.in);
    }
}
