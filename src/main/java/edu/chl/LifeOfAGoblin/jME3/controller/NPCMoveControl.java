/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.model.AIAction;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author Ulrika Uddeborg
 */
public class NPCMoveControl extends AbstractMoveControl {
 
    private AbstractNPC npcModel;
    private float idleMoveRange;
    
    /**
     * Creates a NPCMoveControl with a default move range and no connected spatial
     */
    public NPCMoveControl() {
        this.idleMoveRange = 1; //Default start value
    }
    
    /**
     * Creates a NPCMoveControl with a specified move range and no connected spatial
     * @param idleMoveRange the move range
     */
    public NPCMoveControl(float idleMoveRange) {
        this.idleMoveRange = idleMoveRange;
    }
    
    /**
     * Creates a NPCMoveControl with a default move range and connects a spatial
     * @param spatial the spatial to put the control on
     */
    public NPCMoveControl(Spatial spatial) {
        this();
        this.setSpatial(spatial);
    }
    
    /**
     * Creates a NPCMoveControl with a specified move range and connects a spatial
     * @param idleMoveRange the move range 
     * @param spatial the spatial to put the control on
     */
    public NPCMoveControl(float idleMoveRange, Spatial spatial) {
        this(idleMoveRange);
        this.setSpatial(spatial);
    }
    
    @Override
    public void controlUpdate(float tpf) {
        if (npcModel != null) {
            AIAction action = npcModel.getAIAction();
            switch (action) {
                case IDLE:
                    if (idleMoveRange == 0 && left != right) {
                        right = !right;
                        left = !left;
                        idleMoveRange = 2;
                    }
                    break;
                case MOVETOTARGET:
                    String direction = npcModel.getTargetDirection();
                    if (direction.equals("left")) {
                        left = true;
                        right = false;
                    } else if (direction.equals("right")) {
                        right = true;
                        left = false;
                    }
            }
            super.controlUpdate(tpf);
        }
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        INode n = this.spatial.getControl(ModelControl.class).getModel();
        if (n.getClass() == AbstractNPC.class) {
            npcModel = (AbstractNPC)n;
        }
    }
    
}
