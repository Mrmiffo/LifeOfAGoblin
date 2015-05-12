/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;

/**
 * A class representing a checkpoint that is responsible for updating progress
 * on collision with a player.
 * @author fredrik
 */

public class Checkpoint extends AbstractCollisionObject {
    private int level;
    private int number;
    
     /**
     * constructor for creating a checkpoint with a specified width
     * @param level the level containing the checkpoint
     * @param number the number of the checkpoint in relation to the other
     * checkpoints in the level
     */
    
        public Checkpoint(int level, int number, float width ){
        super(width);
        this.level = level;
        this.number = number;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    
    @Override
    public void collide(){
        updateProgress(this.level, this.number);      
        System.out.println("checkpoint");
        super.setIsActivated(true);
    }
    
    /**
     * tells progress to update itself with given values
     * @param level the level this checkpoint belongs to.
     * @param number this checkpoints position related to all other checkpoints 
     * on this level.
     */
    
    private void updateProgress(int level, int number) {
        //progress.getInstance().update(level, number);
    }
    
}
