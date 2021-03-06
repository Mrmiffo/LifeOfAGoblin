package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.ISpawnable;

/**
 * The AbstractNPC class is the super class to all characters that use AI.
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter implements IAI, ISpawnable {
   
    protected AIAction activeAction;
    private String targetNodeType;
    private Direction targetDirection;
    private float aggressionRange;
    private Weapon weapon;
    
    /**
     *
     * @param maxHealth the max health of the NPC.
     * @param model the model texture to load for the NPC. Must be placed in the assets/model folder.
     * @param height the height of the NPC.
     * @param width the width (along the X-axis) of the NPC.
     * @param collisionHeight the height within which the NPC can collide. 
     * @param collisionWidth the width within which the NPC can collide.
     * @param weight the weight of the NPC.
     * @param baseDamage the NPC's unmodified damage.
     * @param jumpStrength the height the NPC reaches by jumping.
     * @param target the target that the NPC should be hostile toward.
     * @param aggressionRange the range within which the NPC is aggressive.
     * @param weapon which weapon the NPC uses.
     */
    protected AbstractNPC(int maxHealth, String model, float height, float width,
                          float collisionHeight, float collisionWidth, float weight,
                          float baseDamage, float jumpStrength, String target,
                          float aggressionRange, Weapon weapon){
        
        super(maxHealth, model, height, width, collisionHeight,
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
    public void updateAIAction(float distance, Direction direction, String type) {
        if (targetNodeType.equals(type)) {
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
    
    /**
     * Returns the weapon of the NPC.
     * @return the weapon of the NPC.
     */
    public Weapon getWeapon() {
        return weapon;
    }
    
    /**
     * Returns the direction to the NPC's target
     * @return the direction to the target
     */
    public Direction getTargetDirection() {
        return targetDirection;
    }
}
