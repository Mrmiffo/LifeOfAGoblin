/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnControl;

/**
 * A class representing a spawnpoint attached to an object in the game that with
 * a size that tells the level to spawn NPCs when a player gets within its size.
 * @author fredrik
 */
public class SpawnPoint extends AbstractCollisionObject implements ICollidable {
    private int amount;
    private NodeType type;
    private ISpawnControl spawner;
       /**
     * Constructor for creating a Spawnpoint with a different size than its 
     * parent's modelShape
     * modelShape
     * @param amount how many NPCs should spawn
     * @param type what type of NPC should spawn
     * @param parent the AbstractGameObject the spawnpoint is associated with
     */
        public SpawnPoint(ISpawnControl spawner, int amount, NodeType type,
        float width){
        super(width);
        this.spawner = spawner;
        this.amount = amount;
        this.type = type;
    }
    
    /**
     * sets wheter or not this spawnpoint has been activated
     * in this game.
     * @param isActivated true if the player has collided with this 
     * spawnpoint during this game.
     */
    
    @Override
    public NodeType getNodeType() {
        return NodeType.SPAWNPOINT;
    }

    /**
     * is called when a player collides with the Spawnpoint. Tells level to 
     * spawn a number of certain type of NPC according to the spawnpoint's
     * amount and type.
     */
    @Override
    public void collide(){
        Spawn(amount, type);
        System.out.println("spawnpoint");
        super.setActivated(true);
    }

    private void Spawn(int amount, NodeType type) {
        spawner.Spawn(amount, type);
    }
    
}
