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
    private AbstractGameObject parent;
    
    public AbstractCollisionObject(AbstractGameObject parent, 
            float height, float width){
        this.IsActivated = false;
        this.parent = parent;
        this.IsActivated = false;
        this.height = height;
        this.width = width; 
    }
    
    public AbstractCollisionObject(AbstractGameObject parent){
        this.IsActivated = false;
        this.parent = parent;
        this.height = parent.getHeight();
        this.width = parent.getWidth();
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
    
    public AbstractGameObject getParent(){
        return this.parent;
    }


}
