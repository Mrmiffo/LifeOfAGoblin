package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.interfaces.IActivatable;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * A class representing a checkpoint that is responsible for updating progress
 * on collision with a player.
 * @author fredrik
 */

public class Checkpoint extends AbstractGameObject implements ICollidable, IActivatable {
    
    private final static float height = 100;
    private int level;
    private int number;
    private float width;
    private boolean activated;
    
     /**
     * constructor for creating a checkpoint
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     */
    
        public Checkpoint(int level, int number, float width ){
        this.width = width;
        this.level = level;
        this.number = number;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    
     /**
     * Is called when a player collides with the Checkpoint. Runs 
     * updateProgress with this object's level and number and sets IsActivated to true
     */
    @Override
    public void collide(ICollidable collided){
        if (!activated && collided.getClass() == Player.class) {
            updateProgress(this.level, this.number);
            this.activate();
        }
    }
    
    /**
     * tells progress to update itself with given values
     * @param level the level this checkpoint belongs to.
     * @param number this checkpoints position related to all other checkpoints 
     * on this level.
     */
    
    public void updateProgress(int level, int number) {
        //progress.getInstance().update(level, number);
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void activate() {
        activated = true;
    }

    @Override
    public void inactivate() {
        activated = false;
    }

    @Override
    public boolean isActivated() {
        return activated;
    }
    
}
