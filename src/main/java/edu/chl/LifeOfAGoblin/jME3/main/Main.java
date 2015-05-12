/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.main;

import edu.chl.LifeOfAGoblin.jME3.view.LifeOfAGoblin;

/**
 *
 * @author Anton
 */
public class Main {
    private static LifeOfAGoblin game;
    public static void main(String[] args){
        game = new LifeOfAGoblin();
        game.start();
    }
    public static void shutDown(){
        game.stop();
    }
}
