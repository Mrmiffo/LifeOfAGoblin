/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractInanimateObject;

/**
 *
 * @author Anton
 */
public class Checkpoint extends AbstractInanimateObject {
    
    public Checkpoint(){
        super("Checkpoint");
        object.setUserData("objectType", "Checkpoint");
    }
    
    
}
