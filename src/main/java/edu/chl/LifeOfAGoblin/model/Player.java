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
    
    private static Player instance;
    private static int maxHealth = 5;
    
    private Player(){
        super(maxHealth, "Goblin2.j3o", 1, 0.5f, 10, 0, 0);   
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    }
    
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }
        
}
