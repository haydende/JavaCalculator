
package JavaCalculator.ActionHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 * Class containing private classes using the ActionListener interface. This 
 * group is for ActionListeners attached to JMenuItems under the 'File' JMenu.
 * @author Hayden Eastwell
 */
public class FileMenuHandlers {
    
    /**
     * Instance of ActionListener for 'saveHistItem' JMenuItem.
     */
    public class SaveHistHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // TODO
        }
    }
    
    /**
     * Instance of ActionListener for 'copyItem' JMenuItem.
     */
    public class CopyHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // TODO
        }
    }
    
    /**
     * Instance of ActionListener for 'cutItem' JMenuItem.
     */
    public class CutHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // TODO
        }
    }
    
    /**
     * Instance of ActionListener for 'pasteItem' JMenuItem.
     */
    public class PasteHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // TODO
        }
    }
    
    /**
     * Instance of ActionListener for 'optionsItem' JMenuItem.
     */
    public class OptionsHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            // TODO
        }
    }
    
    /**
     * Instance of ActionListener for 'quitItem' JMenuItem.
     */
    public class QuitHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            int result = JOptionPane.showConfirmDialog(
                                        null,
                                        "Do you want to quit the application?",
                                        "Quit?",
                                        JOptionPane.YES_NO_OPTION);
                
            if (result == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}
