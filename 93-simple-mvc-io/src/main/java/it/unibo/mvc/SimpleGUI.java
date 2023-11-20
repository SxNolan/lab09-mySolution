package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {


    private final JFrame frame = new JFrame("My first java graphical interface");
    private Controller myController = new Controller();

    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel myPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(myPanel);
        JTextArea myTextArea = new JTextArea();
        myPanel.add(myTextArea, BorderLayout.NORTH);
        JButton myButton = new JButton("Save");
        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myController.writeStringOnCurrentFile(myTextArea.getText());
                } catch (IOException e1) {
                    System.out.println("Error");
                    e1.printStackTrace();
                }
            }
            
        });
        myPanel.add(myButton, BorderLayout.SOUTH);
    }

    private void display() {
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
