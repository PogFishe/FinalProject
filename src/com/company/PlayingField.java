package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class PlayingField extends JPanel {

    public int windowSizeX;
    public int windowSizeY;
    public Player player;
    private PlayingField playingField;
    public static final int SQUARE_SIZE = 25;
    public int gridSize;
    public static final int TICK_SPEED = 50;
    private Timer timer = new Timer();

    public PlayingField(int windowSizeX, int windowSizeY){
        playingField = this;
        timer.scheduleAtFixedRate(loop, 0, PlayingField.TICK_SPEED);
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
        this.setBackground(Color.BLACK);
        this.player = new Player(new Position(200, 200), playingField);
        gridSize = windowSizeX / SQUARE_SIZE;
    }

    BufferedReader br;
    public ArrayList<Position> squares = new ArrayList<Position>();

    TimerTask loop = new TimerTask() {
        @Override
        public void run() {
            playingField.repaint();
        }
    };

    public void load(){
        String[] lines = new String[16];
        try {
            br = new BufferedReader(new FileReader("/Users/jakubroubal/Desktop/Projekt/src/com/company/layout.csv"));
            for (int i = 0; i <= 15; i++) {
                lines[i] = br.readLine();
            }
            for (int i = 0; i < lines.length; i++) {
                String[] temp = lines[i].split(",");
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j].equals("1")){
                        int posX = j * SQUARE_SIZE;
                        int posY = i * SQUARE_SIZE;
                        squares.add(new Position(posX, posY));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(4, 4, 248));
        for (Position p : squares) {
            g.fillRect(p.x, p.y, SQUARE_SIZE, SQUARE_SIZE);
        }
        g.setColor(new Color(46, 46, 59));
        for (int i = 0; i < gridSize; i++) {
            g.drawLine(0, i * SQUARE_SIZE, windowSizeX, i * SQUARE_SIZE);
            g.drawLine(i * SQUARE_SIZE, 0, i * SQUARE_SIZE, windowSizeX);
        }

        g.setColor(new Color(198, 58, 231));
        g.fillRect(player.position.x, player.position.y, SQUARE_SIZE, SQUARE_SIZE);
    }

}
