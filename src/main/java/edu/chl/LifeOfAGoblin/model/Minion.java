/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractHostileNPC;
import edu.chl.LifeOfAGoblin.utils.NodeFactory;

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
    public NodeFactory.NodeType getNodeType() {
        return NodeFactory.NodeType.NPC;
    }
}
