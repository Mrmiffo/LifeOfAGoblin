/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractHostileNPC;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

/**
 *
 * @author Anton
 */
public class Minion extends AbstractHostileNPC {

    public Minion(String model, int health, int maxHealth){
        super(model, health, maxHealth);
//        character.setUserData("objectType", "Minion");
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
