/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.controller.GameHudController;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;

/**
 * The player calss represent the player character in the game. The class 
 * contains methods and values related to the player, such as health, jumpStrength,
 * size etc. 
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
    private static final float jumpStrength = 12;
    
    public Player(){
        super(maxHealth, model, height, width, weight, baseDamage, jumpStrength);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    } 
    
    
    @Override
    public void collide(){
        //todo add methods for colliding with a player
    }
    
    public void collide(AbstractNPC enemy){
        System.out.println("player");
        super.setHealth(super.getHealth()-1);
        //todo add methods for colliding with a player
    }
    
}
