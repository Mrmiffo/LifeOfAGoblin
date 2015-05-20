/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.AIAction;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.interfaces.IAI;
import edu.chl.LifeOfAGoblin.model.interfaces.IIdleBehaviour;

/**
 * The AbstractNPC class is the super class to all characters that use AI.
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter implements IIdleBehaviour, IAI {
   
    protected AIAction activeAction;
    protected float targetDistance;
    protected NodeType targetNodeType;
    protected Direction targetDirection;
    
    /**
     *
     * @param maxHealth the max health of the NPC.
     * @param model the model texture to load for the NPC. Must be placed in the assets/model folder.
     * @param height the height of the NPC.
     * @param width the width (along the X-axis) of the NPC.
     * @param weight the weight of the NPC.
     * @param baseDamage the NPC's unmodified damage.
     * @param jumpStrength the height the NPC reaches by jumping.
     */
    protected AbstractNPC(int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float jumpStrength){
        
        super(maxHealth, model, height, width, weight, baseDamage, jumpStrength);
        activeAction = AIAction.IDLE;
    }
    
    @Override
    public void idleBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateAIAction() {
        activeAction = AIAction.IDLE;
    }
    
        
    @Override
    public void updateAIAction(float distance, Direction direction, NodeType type) {
        if (targetDistance <= distance && targetNodeType == type) {
            activeAction = AIAction.MOVETOTARGET;
            targetDirection = direction;
        }
    }
    
    @Override
    public AIAction getAIAction() {
        return activeAction;
    }
    
    public Direction getTargetDirection() {
        return targetDirection;
    }
}
