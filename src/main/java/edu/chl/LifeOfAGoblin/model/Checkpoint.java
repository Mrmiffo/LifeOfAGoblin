/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractInanimateObject;

/**
 *
 * @author Fredrik
 * A class that represents a node in the game that can update the 
 * progress class and that the player can respawn at.
 */
public class Checkpoint extends AbstractInanimateObject {
    
    public Checkpoint(){
        super("Checkpoint");
        object.setUserData("objectType", "Checkpoint");
    }
    
     
}
