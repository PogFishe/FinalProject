package com.company;

public class Main {

    public static void main(String[] args) {
        int windowSizeX = 400;
        int windowSizeY = 430;
        PlayingField playingField = new PlayingField(windowSizeX, windowSizeY);
        playingField.load();

        Window window = new Window("NIGGER",playingField, windowSizeX, windowSizeY);

    }
}
