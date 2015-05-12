/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractHostileNPC;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;

/**
 *
 * @author Anton
 */
public class Minion extends AbstractHostileNPC {
    
    private static final int maxHealth = 1;
    private static final String model = "";
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    private static final float jumpStrength = 12;

    /**
     *
     * {@inheritDoc}
     */
    public Minion(AbstractCharacter target){
        this(target, 1);   
    }
    
    /**
     *
     * {@inheritDoc}
     * @param healthMultiplyer the multiplier to make the Minion tougher.
     */
    public Minion(AbstractCharacter target, float healthMultiplyer) {
        super((int)healthMultiplyer * maxHealth, model, height, width, weight,
                baseDamage, jumpStrength, target);
    }
    @Override
    public NodeType getNodeType() {
        return NodeType.NPC;
    }
    
    @Override
    public void collide(){
        //todo add methods for colliding with a minion
    }
}
