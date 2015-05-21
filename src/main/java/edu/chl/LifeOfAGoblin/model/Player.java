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
 * The player class represents the player character in the game. The class 
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
    private boolean invulnerable;
    
    public Player(){
        super(playerMoveControl, collsionGroup, maxHealth, model, height, width, weight, baseDamage, jumpStrength);
        this.invulnerable = false;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.PLAYER;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void collide(ICollidable collided) {
        if (!invulnerable && collided instanceof AbstractNPC) {
            setInvulnerablility(true);
            this.decreaseHealth();
        }
        //todo add methods for colliding with a player
    }
    
    /**
     * Describes what happens when the player collides with an NPC.
     * @param enemy the NPC the player collides with.
     */
    @Deprecated
    public void collide(AbstractNPC enemy){
        System.out.println("player");
        setInvulnerablility(true);
        this.decreaseHealth();
        //todo add methods for colliding with a player
    }

    /**
     * Sets whether the player is currently taking damage or not.
     * @param b wether the player is currently taking damage or not.
     */
    public void setInvulnerablility(boolean b) {
        this.invulnerable = b;
    }
    
    /**
     * Returns whether the player is currently taking damage or not.
     * @return whether the player is currently taking damage or not.
     */
    public boolean isInvulnerable(){
        return this.invulnerable;
    }   
}
