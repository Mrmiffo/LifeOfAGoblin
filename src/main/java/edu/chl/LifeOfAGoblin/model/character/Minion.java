package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 * A basic minion NPC. Not yet fully implemented.
 * @author Anton
 */
public class Minion extends AbstractNPC {
    
    private static final int maxHealth = 1;
    private static final float aggressionRange = 4;
    private static final String model = "Goblin2.j3o"; //temporary model for testing purposesdd
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float collisionHeight = 1;
    private static final float collisionWidth = aggressionRange * 2;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    private static final float jumpStrength = 12;

    /**
     * {@inheritDoc}
     */
    public Minion() {
        this(NodeType.PLAYER);
    }
    /**
     * {@inheritDoc}
     */
    public Minion(NodeType target){
        this(target, 1, aggressionRange, new MeleeWeapon());   
    }
    
    /**
     * {@inheritDoc}
     * @param healthMultiplyer the multiplier to make the Minion tougher.
     */
    public Minion(NodeType target, float healthMultiplyer, float aggressionRange, Weapon weapon) {
        super((int)healthMultiplyer * maxHealth, model, height, width,
                collisionHeight, collisionWidth, weight, baseDamage, jumpStrength,
                target, aggressionRange, weapon);
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.MINION;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void collide(ICollidable collided){
        //todo add methods for colliding with a minion
    }
}
