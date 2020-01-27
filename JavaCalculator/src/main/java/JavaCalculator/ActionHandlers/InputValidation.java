
package JavaCalculator.ActionHandlers;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;

/**
 * Subclass of PlainDocument to be used for ensuring only numeric characters are 
 * entered into a JTextField.
 * @author Hayden Eastwell
 */
public class InputValidation extends PlainDocument {
        
    /**
     * Default constructor for this class.
     */
    public InputValidation() {
        super();
    }
    
    /**
     * 
     * @param offset
     * @param str
     * @param set
     * @throws BadLocationException 
     */
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if (str == null) 
            return;
        switch (str) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                super.insertString(offset, str, set); 
        }
    }
}
