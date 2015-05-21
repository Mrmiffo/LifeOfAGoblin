/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * A class representing a checkpoint that is the last checkpoint in the game
 * and when the player collides with the checkpoint the level is completed.
 * @author fredrik
 */
public class FinalCheckpoint extends Checkpoint {
    private int level;
    private int number;
    public FinalCheckpoint(int level, int number, float width){
        super(level, number, width);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.FINALCHECKPOINT;
    }
    
     /**
     * Is called when an ICollidable collides with this finalCheckpoint. Runs 
     * updateProgress with this object's level and number, sets 
     * IsActivated to true and tells the level to end if the object is a Player.
     */
    @Override
    public void collide(ICollidable collided) {
        if (collided.getClass() == Player.class) {
            super.updateProgress(this.level, this.number);
            super.activate();
            StateManagerWrapper.getInstance().detachCurrentState();
            NiftyGUIWrapper.getInstance().showPauseMenu();
        }
    }
}
