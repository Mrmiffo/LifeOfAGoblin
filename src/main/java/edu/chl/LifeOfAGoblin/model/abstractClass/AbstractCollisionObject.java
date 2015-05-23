package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * An abstract class representing an object which purpose is to react in
 * different ways on collision with a Player.
 * @author fredrik
 */
public abstract class AbstractCollisionObject extends AbstractGameObject implements ICollidable{
    private float width;
    private float height;
    private boolean isActivated; 
    /**
     * Creates a new AbstractCollisionObject
     * @param width the length from the object to the edge of the 
     * collisionShape
     */
    public AbstractCollisionObject(float width){
        this.isActivated = false;
        this.isActivated = false;
        this.width = width; 
        this.height = 1000; //just a big number
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
    public void setIsActivated(boolean b){
        this.isActivated = b;
    }
    
    public boolean isActivated(){
        return this.isActivated;
    }
}
