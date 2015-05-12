/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCollisionObject;
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnControl;

/**
 * A class representing a spawnpoint that is responsible for creating new 
 * spawnables in the game when a player collides with it.
 * @author fredrik
 */
public class SpawnPoint extends AbstractCollisionObject {
    private int amount;
    private NodeType type;
    private ISpawnControl spawner;
       /**
     * Constructor for creating a Spawnpoint with a specified width
     * @param spawner the control responsible for creating the spawnables
     * @param amount how many spawnable should spawn
     * @param type what type of spawnable should spawn
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
        super.setIsActivated(true);
    }
    /**
     * Tells this objects spawner to create a number of new spawnables in the
     * game
     * @param amount the number of spawnables to be created
     * @param type the type of spawnable to be created
     */
    private void Spawn(int amount, NodeType type) {
        spawner.Spawn(amount, type);
    }
    
}
