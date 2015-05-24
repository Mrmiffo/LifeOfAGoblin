/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.model.AIAction;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author Ulrika Uddeborg
 */
public class NPCMoveControl extends AbstractMoveControl {
 
    private AbstractNPC npcModel;
    private float maximumIdleMoveRange;
    private float currentMoveRange;
    
    /**
     * Creates a NPCMoveControl with a default move range and no connected spatial
     */
    public NPCMoveControl() {
        this(20); //Default start value
    }
    
    /**
     * Creates a NPCMoveControl with a specified move range and no connected spatial
     * @param idleMoveRange the move range
     */
    public NPCMoveControl(float idleMoveRange) {
        super(0.08f);
        this.maximumIdleMoveRange = idleMoveRange;
        this.currentMoveRange = maximumIdleMoveRange/2;
        this.currentDirection = Direction.LEFT;
    }
    
    @Override
    public void controlUpdate(float tpf) {
        if (npcModel != null) {
            AIAction action = npcModel.getAIAction();
            switch (action) {
                case IDLE:
                    if (Math.abs(currentMoveRange) < 0.05f) {
                        currentDirection = (currentDirection == Direction.LEFT) ?
                                                Direction.RIGHT : Direction.LEFT;
                       currentMoveRange = maximumIdleMoveRange; //10 is full idle range
                    } else {
                        currentMoveRange -= stepWidth;
                    }
                    break;
                case MOVETOTARGET:
                    currentDirection = npcModel.getTargetDirection();
                    break;
                case HALT:
                    currentDirection = Direction.STAND_STILL;
                    break;
                default:
                    currentDirection = Direction.STAND_STILL;
                    break;
            }
            super.controlUpdate(tpf);
        }
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        INode n = this.spatial.getControl(ModelControl.class).getModel();
        if (n instanceof AbstractNPC) {
            npcModel = (AbstractNPC)n;
        }
    }
    
}
