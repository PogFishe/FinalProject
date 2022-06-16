package com.company;

import javax.swing.*;

public class Window extends JFrame {

    public Window(String title, JPanel panel, int sizeX, int sizeY){
        super(title);
        this.add(panel);
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(sizeX, sizeY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
