package it.unibo.mvc.view;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class MyDrawNumberView implements DrawNumberView{

    //Warning: this View is output only!

    private DrawNumberController controller;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
       System.out.println("Hi guys! :)"); 
    }

    @Override
    public void result(DrawResult res) {
        
    }
    
}
