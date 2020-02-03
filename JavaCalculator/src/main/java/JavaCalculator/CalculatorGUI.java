
package JavaCalculator;

import JavaCalculator.ActionHandlers.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class for building the GUI components of the application
 * @author Hayden Eastwell
 */
public class CalculatorGUI {
    
    // Create instance of FileMenuHandlers to gain access to its inner classes
    private FileMenuHandlers fmh = new FileMenuHandlers();
    
    // Create instance of OpBtnHandlers to gain access to its inner classes
    private OpBtnHandlers obh = new OpBtnHandlers();
    
    // Create frame for GUI
    private JFrame frame = new JFrame("JavaCalculator");
    
    // Declare Container for frame
    private Container container;
    
    // Declare JPanels for top and bottom halves
    private JPanel topHalf;
    private JPanel botHalf;
    
    // Create MenuBar 
    private JMenuBar menuBar = new JMenuBar();
    
    // Create Menus and their items
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem saveHistItem = new JMenuItem("Save History...");
    private JMenuItem copyItem = new JMenuItem("Copy");
    private JMenuItem cutItem = new JMenuItem("Cut");
    private JMenuItem pasteItem = new JMenuItem("Paste");
    private JMenuItem optionsItem = new JMenuItem("Options...");
    private JMenuItem quitItem = new JMenuItem("Quit...");
    
    // Create buttons 0-9
    private JButton clear = new JButton("C");
    private JButton backspace = new JButton("<");
    private JButton zeroButton = new JButton("0");
    private JButton oneButton = new JButton("1");
    private JButton twoButton = new JButton("2");
    private JButton threeButton = new JButton("3");
    private JButton fourButton = new JButton("4");
    private JButton fiveButton = new JButton("5");
    private JButton sixButton = new JButton("6");
    private JButton sevenButton = new JButton("7");
    private JButton eightButton = new JButton("8");
    private JButton nineButton = new JButton("9");
    
    // Create =, +, -, / and * buttons
    private JButton equalsButton = new JButton("=");
    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton divButton = new JButton("/");
    private JButton mulButton = new JButton("*");
    
    public CalculatorGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame);
            
        } catch (Exception e) {
            
        }
        makeFrame();
    }
    
    /**
     * Method for creating the main window of the UI.
     */
    private void makeFrame() {
        
        // Add a container with a BoxLayout for the JPanels
        container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        // Create JPanel for the top half of the UI
        topHalf = new JPanel();
        // Set a box layout 
        topHalf.setLayout(new BoxLayout(topHalf, BoxLayout.X_AXIS));
        // Add topHalf to the Container
        container.add(topHalf);
        
        // Create JPanel for the bottom half of the UI
        botHalf = new JPanel();
        // Set a box layout
        botHalf.setLayout(new BoxLayout(botHalf, BoxLayout.X_AXIS));
        // Add botHalf to the container
        container.add(botHalf);
                
        // Create the input area JPanel
        createInputArea();
        
        // Create the numpad JPanel
        createNumpad();
        
        // Create the Operator buttons JPanel
        createOpButtons();
        
        // Create the frame's MenuBar
        createMenuBar();
        
        // Set the window's default close operation as nothing so that the 
        // window listener can be enacted instead
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Add the window listener 
        addCloseListener();
        
        // Set the size of the frame tp 400 x 220
        frame.setSize(400, 250);      
        
        // Make the window start in the center of the screen
        frame.setLocationRelativeTo(null);
          
        // Make the new frame visible
        frame.setVisible(true);
    }
    
    /**
     * Method for creating the main window's MenuBar.
     */
    private void createMenuBar() {
        
        // Add ActionListeners to the JMenuItems
        saveHistItem.addActionListener(fmh.new SaveHistHandler()); // Save History...
        copyItem.addActionListener(fmh.new CopyHandler());         // Copy
        cutItem.addActionListener(fmh.new CutHandler());           // Cut
        pasteItem.addActionListener(fmh.new PasteHandler());       // Paste
        optionsItem.addActionListener(fmh.new OptionsHandler());   // Options...
        quitItem.addActionListener(fmh.new QuitHandler());         // Quit...
        
        // Add the JMenuItems to the JMenus
        fileMenu.add(saveHistItem);                                // Save History...
        fileMenu.add(copyItem);                                    // Copy
        fileMenu.add(cutItem);                                     // Cut
        fileMenu.add(pasteItem);                                   // Paste
        fileMenu.add(optionsItem);                                 // Options...
        fileMenu.add(quitItem);                                    // Quit...
        
        // Add the JMenus to the JMenuBar
        menuBar.add(fileMenu);
        
        // Set the JMenuBar for the main window
        frame.setJMenuBar(menuBar);
    }
    
    /**
     * Method for creating the JLabel and JTextField at the top of the window.
     */
    private void createInputArea() {
        
        // Add a JPanel for the JLabel and JTextField
        JPanel equation = new JPanel();
        equation.setLayout(new BoxLayout(equation, BoxLayout.Y_AXIS));
        
        // JLabel for the current equation
        JLabel currentEquation = new JLabel("0");
        currentEquation.setForeground(Color.GRAY);
        
        // Create JTextField for the user input
        JTextField input = new JTextField();
        // Set maximum size for the text field to make sure it doesn't get too big
        input.setMaximumSize(new Dimension(400, 25));
        
        // Set the Document object as InputValidation() to ensure only numbers
        input.setDocument(new InputValidation());
        
        equation.add(currentEquation);
        equation.add(input);
        
        // Add the equation JPanel to the top half
        topHalf.add(equation);
    }
    
    /**
     * Method for creating the numpad JButtons.
     */
    private void createNumpad() {
        
        // Add a GridLayout with 4 rows and 5 columns to the container
        // GridLayout is set to have 5px space vertical and horizontal
        JPanel numpad = new JPanel();
        numpad.setLayout(new GridLayout(4, 5, 3, 3));
        
        // Adding the numpad JButtons to the GridLayout
        numpad.add(clear);
        numpad.add(backspace);
        numpad.add(zeroButton);
        numpad.add(oneButton);
        numpad.add(twoButton);
        numpad.add(threeButton);
        numpad.add(fourButton);
        numpad.add(fiveButton);
        numpad.add(sixButton);
        numpad.add(sevenButton);
        numpad.add(eightButton);
        numpad.add(nineButton);   
        
        // Add the numpad JPanel to the bottom half
        botHalf.add(numpad);        
    }
    
    /**
     * Method for creating the Operator JButtons.
     */
    private void createOpButtons() {
        
        // Add ActionListeners to the JButtons
        equalsButton.addActionListener(obh.new EqualsHandler());        // =
        addButton.addActionListener(obh.new AdditionHandler());         // +
        subButton.addActionListener(obh.new SubtractionHandler());      // -
        divButton.addActionListener(obh.new DivisionHandler());         // /
        mulButton.addActionListener(obh.new MultiplicationHandler());   // * 
        
        JPanel opBtns = new JPanel();
        opBtns.setLayout(new BoxLayout(opBtns, BoxLayout.Y_AXIS));
        
        opBtns.add(equalsButton);
        opBtns.add(addButton);
        opBtns.add(subButton);
        opBtns.add(divButton);
        opBtns.add(mulButton);
        
        // Add the opBtns JPanel to the bottom half
        botHalf.add(opBtns);
    }
    
    /**
     * Method for adding a Window Listener that creates a confirmation dialog
     * when the user is trying to close the window.
     */
    private void addCloseListener() {
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                
                // Create Confirm dialog and store result
                int result = JOptionPane.showConfirmDialog(frame, 
                                                           "Are you sure you want to quit?", 
                                                           "Quit?", 
                                                           JOptionPane.YES_NO_OPTION);
                
                // If captured result is the yes option...
                if (result == JOptionPane.YES_OPTION)
                    // Set the close operation to EXIT_ON_CLOSE (Application ends)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    
}
