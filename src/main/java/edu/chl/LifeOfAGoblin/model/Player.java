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
    private static final int maxHealth = 5;
    private static final String model = "Goblin2.j3o";
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    
    private Player(){
        super(maxHealth, model, height, width, weight, baseDamage);
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
    
    @Override
        public void collide(){
        //todo add methods for colliding with a player
    }
}
