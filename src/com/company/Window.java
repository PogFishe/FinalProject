package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {

    public PlayingField playingField;

    public Window(String title, JPanel panel, int sizeX, int sizeY, PlayingField playingField){
        super(title);
        this.playingField = playingField;
        this.add(panel);
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(sizeX, sizeY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'd' -> playingField.player.holdingRight = true;
            case 'a' -> playingField.player.holdingLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'd' -> playingField.player.holdingRight = false;
            case 'a' -> playingField.player.holdingLeft = false;
        }
    }
}
