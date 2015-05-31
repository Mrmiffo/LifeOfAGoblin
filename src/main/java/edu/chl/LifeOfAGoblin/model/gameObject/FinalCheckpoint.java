package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 * A class representing a checkpoint that is the last checkpoint in the game
 * and when the player collides with the checkpoint the level is completed.
 * @author fredrik
 */
public class FinalCheckpoint extends Checkpoint {
    public FinalCheckpoint(int level, int number, float width){
        super(level, number, width);
    }
    
     /**
     * Is called when an ICollidable collides with this finalCheckpoint. Runs 
     * updateProgress with this object's level and number, sets 
     * IsActivated to true and tells the level to end if the object is a Player.
     */
    @Override
    public void collide(ICollidable collided) {
        super.collide(collided);
    }
}
