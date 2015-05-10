/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 * 
 * @author fredrik
 */
public class Checkpoint implements INode, ICollidable {
    private int level;
    private int number;
    private boolean activated;
    private AbstractGameObject parent;
    private float height;
    private float width;
    /**
     * constructor for creating a checkpoint with a  collisionbody the same size
     * as its parent's modelShape
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     * @param parent the AbstractGameObject the checkpoint is associated with.
     */
    public Checkpoint(int level, int number, AbstractGameObject 
            parent){
        this.level = level;
        this.number = number;
        this.activated = false;
        this.parent = parent;
        this.height = parent.getModelShapeHeight;
        this.width = parent.getModelShapeWidth;
        
    }
        /**
     * constructor for creating a checkpoint with a larger collisionbody than
     * its parent's modelShape
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     * @param parent the AbstractGameObject the checkpoint is associated with.
     */
        public Checkpoint(int level, int number, AbstractGameObject 
            parent, float height, float width ){
        this.level = level;
        this.number = number;
        this.activated = false;
        this.parent = parent;
        this.height = height;
        this.width = width;
        
    }
    
    
    /**
     * sets wheter or not this CheckpointControl has been activated
     * in this game.
     * @param isActivated true if the player has collided with this 
     * checkpointControl during this game.
     */
    public void setActivated(boolean isActivated){
        this.activated = isActivated;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    
    public AbstractGameObject getParent(){
        return this.parent;
    }
    
    public float getWidth(){
        return this.width;
    }
    
    public float getHeight(){
        return this.height;
        
    }
    /**
     * is called when a player collides with the checkpoint. Tells progress
     * to update itself if neccesary and sets activated to true
     */
    @Override
    public void Collision(){
        
        //Progress.getInstance.update(this.level, this.number);
        System.out.println("checkpoint");
        setActivated(true);
    }
    
}
