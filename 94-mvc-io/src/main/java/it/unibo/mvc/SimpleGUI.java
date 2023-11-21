package it.unibo.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    Controller myController = new SimpleController();

    public SimpleGUI() {
        JPanel myPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(myPanel);
        JTextField myTextField = new JTextField();
        myPanel.add(myTextField, BorderLayout.NORTH);
        JTextArea myTextArea = new JTextArea();
        myPanel.add(myTextArea, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myController.setNextString(myTextField.getText());
                myController.printCurrentString();
            }
            
        });
        
        buttonPanel.add(printButton);
        JButton showHistoryButton = new JButton("Show history");
        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myTextArea.setText(null);
                for (String elem : myController.getHistoryPrintedStrings()) {
                    myTextArea.append(elem + " | ");
                }
            }
            
        });
        
        buttonPanel.add(showHistoryButton);
        myPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
