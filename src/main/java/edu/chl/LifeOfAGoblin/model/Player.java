/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;

/**
 * The player calss represent the player character in the game. The class 
 * contains methods and values related to the player, such as health, jumpStrength,
 * size etc. 
 * @author Anton
 */
public class Player extends AbstractCharacter {
    
    private static final PlayerMoveControl playerMoveControl = new PlayerMoveControl();
    private static final int collsionGroup = 2;
    private static final int maxHealth = 5;
    private static final String model = "Goblin2.j3o";
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    private static final float jumpStrength = 12;
    private boolean isDamaged;
    
    public Player(){
        super(playerMoveControl, collsionGroup, maxHealth, model, height, width, weight, baseDamage, jumpStrength);
        this.isDamaged = false;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    } 
     
    @Override
    public void collide(ICollidable collided) {
        if (collided instanceof AbstractNPC) {
            setIsDamaged(true);
            this.decreaseHealth();
        }
        //todo add methods for colliding with a player
    }
    
    @Deprecated
    public void collide(AbstractNPC enemy){
        System.out.println("player");
        setIsDamaged(true);
        this.decreaseHealth();
        //todo add methods for colliding with a player
    }

    public void setIsDamaged(boolean b) {
        this.isDamaged = b;
    }
    
    public boolean getIsDamaged(){
        return this.isDamaged;
    }
    
}
