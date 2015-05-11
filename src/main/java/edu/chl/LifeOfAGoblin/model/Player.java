/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

/**
 *
 * @author Anton
 */
public class Player extends AbstractCharacter {
    private float height = 1f;
    private float width = 0.5f;
    
    public Player(int health, int maxHealth){
        super("Goblin2.j3o", health, maxHealth);

    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    }
        
}
