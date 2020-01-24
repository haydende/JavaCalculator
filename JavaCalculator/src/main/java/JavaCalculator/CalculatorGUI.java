/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCalculator;
import JavaCalculator.ActionHandlers.*;
import javax.swing.*;

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
    
    // Create =, +, -, / and * buttons
    private JButton equalsButton = new JButton("=");
    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton divButton = new JButton("/");
    private JButton mulButton = new JButton("*");
    
    public CalculatorGUI() {
        makeFrame();
    }
    
    private void makeFrame() {
        
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
        
        // Add ActionListeners to the JButtons
        equalsButton.addActionListener(obh.new EqualsHandler());        // =
        addButton.addActionListener(obh.new AdditionHandler());         // +
        subButton.addActionListener(obh.new SubtractionHandler());      // -
        divButton.addActionListener(obh.new DivisionHandler());         // /
        mulButton.addActionListener(obh.new MultiplicationHandler());   // * 
        
        // Make the new frame visible
        frame.setVisible(true);
    }
}
