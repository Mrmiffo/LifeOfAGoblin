/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.scene.Node;
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
    
    public NPCMoveControl() {
        INode n = this.spatial.getControl(ModelControl.class).getModel();
        if (n.getClass() == AbstractNPC.class) {
            npcModel = (AbstractNPC)n;
        }
    }
    
    public NPCMoveControl(float idleMoveRange) {
        this();
        this.idleMoveRange = 1; //Start value
    }
    
    @Override
    public void controlUpdate(float tpf) {
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
