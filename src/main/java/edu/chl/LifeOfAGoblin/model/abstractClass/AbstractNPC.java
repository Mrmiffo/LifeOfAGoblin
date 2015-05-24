package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.controller.NPCMoveControl;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.AIAction;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.Weapon;
import edu.chl.LifeOfAGoblin.model.interfaces.IAI;

/**
 * The AbstractNPC class is the super class to all characters that use AI.
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter implements IAI {
   
    protected AIAction activeAction;
    private NodeType targetNodeType;
    private Direction targetDirection;
    private float aggressionRange;
    private Weapon weapon;
    
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
                          float collisionHeight, float collisionWidth, float weight,
                          float baseDamage, float jumpStrength, NodeType target,
                          float aggressionRange, Weapon weapon){
        
        super(new NPCMoveControl(), maxHealth, model, height, width, collisionHeight,
                collisionWidth, weight, baseDamage, jumpStrength);
        this.targetNodeType = target;
        this.aggressionRange = aggressionRange;
        this.weapon = weapon;
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
        if (targetNodeType == type) {
            if (aggressionRange >= distance) {
                if (distance <= 1) {
                    activeAction = AIAction.HALT;
                } else {
                    activeAction = AIAction.MOVETOTARGET;
                }
            } else {
                activeAction = AIAction.IDLE;
            }
            targetDirection = direction;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public AIAction getAIAction() {
        return activeAction;
    }
    
    public Weapon getWeapon() {
        return weapon;
    }
    
    /**
     * Returns the direction to the NPC's target
<<<<<<< HEAD
=======
     * @return the direction to the target
>>>>>>> CorrectNPCAI
     */
    public Direction getTargetDirection() {
        return targetDirection;
    }
}
