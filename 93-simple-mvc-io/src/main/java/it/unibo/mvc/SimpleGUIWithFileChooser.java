package it.unibo.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private Controller myController = new Controller();

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
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

        JPanel mySecondPanel = new JPanel(new BorderLayout());
        myPanel.add(mySecondPanel, BorderLayout.NORTH);
        JTextField myTextField = new JTextField();
        mySecondPanel.add(myTextField, BorderLayout.CENTER);
        JButton browseButton = new JButton("Browse...");
        mySecondPanel.add(browseButton, BorderLayout.AFTER_LINE_ENDS);
        JFileChooser myFileChooser = new JFileChooser();
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = myFileChooser.showSaveDialog(browseButton);
                if (i == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = myFileChooser.getSelectedFile();
                    myTextField.setText(selectedFile.getName());
                    myController.setCurrentFile(selectedFile.getAbsolutePath());
                } else if (i == JFileChooser.CANCEL_OPTION) {

                } else {
                    JOptionPane.showMessageDialog(myFileChooser, "An error has occurred.");
                }   
            }
            
        });
    }

    private void display() {
        frame.pack();
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
