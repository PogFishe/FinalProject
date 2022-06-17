package com.company;

import java.util.Timer;
import java.util.TimerTask;

public class Player {

    public Position position;
    private PlayingField playingField;
    private Timer timer = new Timer();
    public boolean holdingRight = false;
    public boolean holdingLeft = false;
    private int fallingSpeed = 2;
    private int speed = 10;

    public Player(Position position, PlayingField playingField){
        this.position = position;
        this.playingField = playingField;
        timer.scheduleAtFixedRate(loop, 0, PlayingField.TICK_SPEED);
    }

    TimerTask loop = new TimerTask() {
        @Override
        public void run() {
            // Gravitace
            if (!isColiding()){
                position.y += fallingSpeed;
            }
            // Movement
            Position dir;
            if (holdingRight && holdingLeft == false){
                dir = new Position(1,0);
            }else if (holdingLeft && holdingRight == false){
                dir = new Position(-1, 0);
            }else {
                dir = new Position(0,0);
            }
            position.x += dir.x * speed;
            System.out.println("left: " + holdingLeft);
            System.out.println("right: " + holdingRight);
        }
    };

    private boolean isColiding(){
        int temp = PlayingField.SQUARE_SIZE;
        for (Position pos : playingField.squares) {
            if ((position.x + temp >= pos.x && position.x <= pos.x + temp) && (position.y + temp >= pos.y && position.y <= pos.y + temp)) {
                return true;
            }
        }
        return false;
    }

}
