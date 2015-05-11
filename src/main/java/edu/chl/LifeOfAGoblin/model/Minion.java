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
    private static final float weight = 19;
    private static final float baseDamage = 1;
    private static final float baseArmour = 0;

    public Minion(AbstractCharacter target){
        this(target, 1);   
    }
    
    public Minion(AbstractCharacter target, float healthMultiplyer) {
        super((int)healthMultiplyer * maxHealth, model, height, width, weight,
                baseDamage, baseArmour, target);
    }
    @Override
    public NodeType getNodeType() {
        return NodeType.NPC;
    }

    @Override
    public void Collision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
