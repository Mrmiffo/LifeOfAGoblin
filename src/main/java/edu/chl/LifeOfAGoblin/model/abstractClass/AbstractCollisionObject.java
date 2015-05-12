/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 *
 * @author fredrik
 */
public abstract class AbstractCollisionObject extends AbstractGameObject implements ICollidable{
    private float width;
    private float height;
    private boolean IsActivated; 
    
    public AbstractCollisionObject(float width){
        this.IsActivated = false;
        this.IsActivated = false;
        this.width = width; 
        this.height = 1000; //arbitary big number
    }
     
    @Override
    public float getWidth(){
        return this.width;
    }
    
    @Override
    public float getHeight(){
        return this.height;
    }
        /**
     * sets wheter or not this Checkpoint has been activated
     * in this game.
     * @param isActivated true if the player has collided with this 
     * checkpointControl during this game.
     */
    
    public void setActivated(boolean isActivated){
        this.IsActivated = isActivated;
    }
    
    public boolean getIsActivated(){
        return this.IsActivated;
    }
}
