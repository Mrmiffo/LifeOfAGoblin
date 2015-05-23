/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.controller.AbstractMoveControl;
import edu.chl.LifeOfAGoblin.jME3.controller.NPCMoveControl;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.AIAction;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.interfaces.IAI;

/**
 * The AbstractNPC class is the super class to all characters that use AI.
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter implements IAI {
   
    protected AIAction activeAction;
    protected float targetDistance = 2;
    protected NodeType targetNodeType;
    protected Direction targetDirection;
    
    private float aggressionRange = 3;
    
    private static final int collisionGroup = 6;
    
    /**
     *
     * @param maxHealth the max health of the NPC.
     * @param model the model texture to load for the NPC. Must be placed in the assets/model folder.
     * @param height the height of the NPC.
     * @param width the width (along the X-axis) of the NPC.
     * @param weight the weight of the NPC.
     * @param baseDamage the NPC's unmodified damage.
     * @param jumpStrength the height the NPC reaches by jumping.
     * @param target the target that the NPC should be hostile toward
     */
    protected AbstractNPC(int maxHealth, String model, float height, float width,
            float weight, float baseDamage, float jumpStrength, NodeType target){
        
        super(new NPCMoveControl(), collisionGroup, maxHealth, model, height, width, weight, baseDamage, jumpStrength);
        activeAction = AIAction.IDLE;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAIAction() {
        activeAction = AIAction.IDLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAIAction(float distance, Direction direction, NodeType type) {
        if (aggressionRange <= distance && targetNodeType == type) {
            if (distance <= 0.5f) {
                activeAction = AIAction.HALT;
            } else {
                activeAction = AIAction.MOVETOTARGET;
            }
        } else {
            activeAction = AIAction.IDLE;
        }
        System.out.println(activeAction);
        targetDirection = direction;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public AIAction getAIAction() {
        return activeAction;
    }
    
    /**
     * Returns the direction to the NPC's target
     * @return the direction to the target
     */
    public Direction getTargetDirection() {
        return targetDirection;
    }
}
