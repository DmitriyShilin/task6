package formatstring;

import formatstring.exception.LargeNumberValueException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {
    
    private static Logger logger = Logger.getLogger(MainApp.class.getName());
    
    public static void main(String[] args) {
        FormatString formatString1 = new FormatString(1234, 123);
        try {
            formatString1.multiply();
        } catch (LargeNumberValueException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        FormatString formatString2 = new FormatString(6, 6);
        try {
            formatString2.multiply();
        } catch (LargeNumberValueException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        FormatString formatString3 = new FormatString(6, 456);
        try {
            formatString3.multiply();
        } catch (LargeNumberValueException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }    
}
