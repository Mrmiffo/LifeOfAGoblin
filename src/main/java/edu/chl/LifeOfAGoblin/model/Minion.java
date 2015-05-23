package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * A basic minion NPC. Not yet fully implemented.
 * @author Anton
 */
public class Minion extends AbstractNPC {
    
    private static final int maxHealth = 1;
    private static final String model = "Goblin2.j3o"; //temporary model for testing purposesdd
    private static final float height = 1;
    private static final float width = 0.4f;
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
        this(target, 1);   
    }
    
    /**
     * {@inheritDoc}
     * @param healthMultiplyer the multiplier to make the Minion tougher.
     */
    public Minion(NodeType target, float healthMultiplyer) {
        super((int)healthMultiplyer * maxHealth, model, height, width, weight,
                baseDamage, jumpStrength, target);
        
        targetNodeType = NodeType.PLAYER;
        targetDistance = 2;
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
