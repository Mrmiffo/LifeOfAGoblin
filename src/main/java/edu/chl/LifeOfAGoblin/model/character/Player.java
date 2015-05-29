package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.jME3.character.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 * The player class represents the player character in the game. The class 
 * contains methods and values related to the player, such as health, jumpStrength,
 * size etc. 
 * @author Anton
 */
public class Player extends AbstractCharacter {
    
    private static final int maxHealth = 5;
    private static final String model = "Goblin2.j3o";
    private static final float height = 1;
    private static final float width = 0.4f;
    private static final float weight = 10;
    private static final float baseDamage = 1;
    private static final float jumpStrength = 14;
    private boolean invulnerable;
    
    public Player(){
        super(maxHealth, model, height, width, height, width, weight, baseDamage, jumpStrength);
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
        if (!invulnerable && collided instanceof Weapon) {
            setInvulnerablility(true);
            this.decreaseHealth();
        }
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
