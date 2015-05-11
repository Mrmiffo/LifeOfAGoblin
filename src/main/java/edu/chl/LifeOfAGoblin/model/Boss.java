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
public class Boss extends AbstractHostileNPC {
    
    private static final int maxHealth = 100;
    private static final String model = "";
    private static final float height = 10;
    private static final float width = 7;
    private static final float weight = 1000;
    private static final float baseDamage = 10;
    
    /**
     * 
     * {@inheritDoc}
     */
    public Boss(AbstractCharacter target) {
        this(target, 1);
    }
    
    /**
     *
     * {@inheritDoc}
     * @param healthMultiplier the multiplier to make the Boss tougher.
     */
    public Boss(AbstractCharacter target, float healthMultiplier) {
        super((int)healthMultiplier * maxHealth, model, height, width, weight,
                baseDamage, target);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.NPC;
    }
    
    @Override
    public void collide(){
        //todo add methods for colliding with a boss
    }
}
