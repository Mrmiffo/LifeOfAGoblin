/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.main;

import edu.chl.LifeOfAGoblin.jME3.view.LifeOfAGoblin;

/**
 * The main class is used to create an instance of the game and provides the ability to turn it off.
 * @author Anton
 */
public class Main {
    private static LifeOfAGoblin game;
    /**
     * Starts the game. No arguments are used in the code.
     * @param args 
     */
    public static void main(String[] args){
        game = new LifeOfAGoblin();
        game.start();
    }
    /**
     * Shuts down the application, returning to desktop.
     */
    public static void shutDown(){
        game.stop();
    }
}
