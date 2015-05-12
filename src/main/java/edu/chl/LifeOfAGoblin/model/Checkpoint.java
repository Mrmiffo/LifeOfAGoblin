/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
/**
 * a class representing a checkpoint attached to an object in the game 
 * with a size that updates the progress class when a player gets 
 * within its size.
 * @author fredrik
 */
public class Checkpoint extends AbstractCollisionObject {
    private int level;
    private int number;
    /**
     * constructor for creating a checkpoint with the same size
     * as its parent's modelShape
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     * @param parent the AbstractGameObject the checkpoint is associated with.
     */
    public Checkpoint(int level, int number, AbstractGameObject parent){
        super(parent);
        this.level = level;
        this.number = number;
    }
        /**
     * constructor for creating a checkpoint with a different size than
     * its parent's modelShape
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     * @param parent the AbstractGameObject the checkpoint is associated with.
     */
        public Checkpoint(int level, int number, AbstractGameObject 
            parent, float height, float width ){
        super(parent, height, width);
        this.level = level;
        this.number = number;
    }
    
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    
    /**
     * is called when a player collides with the checkpoint. Tells progress
     * to update itself if neccesary and sets activated to true
     */
    @Override
    public void collide(){
        
        //Progress.getInstance.update(this.level, this.number);
        System.out.println("checkpoint");
        super.setActivated(true);
    }
    
}
