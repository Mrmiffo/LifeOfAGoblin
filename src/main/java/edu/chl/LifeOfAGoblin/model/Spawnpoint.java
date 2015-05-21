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
public class Spawnpoint extends AbstractCollisionObject {
    
    private int amount;
    private NodeType type;
    private ISpawnControl spawner;
    
     /**
     * Constructor for creating a Spawnpoint
     * @param spawner the control responsible for creating the spawnables
     * @param amount how many spawnable should spawn
     * @param type what type of spawnable should spawn
     */
     public Spawnpoint(ISpawnControl spawner, int amount, NodeType type, float width) {
         super(width);
         this.spawner = spawner;
         this.amount = amount;
         this.type = type;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.SPAWNPOINT;
    }

    /**
     * Is called when a player collides with the Spawnpoint. Runs spawn with 
     * this object's amount and type and sets IsActivated to true
     */
    @Override
    public void collide() {
        spawn(amount, type);
        System.out.println("spawnpoint");
        super.setIsActivated(true);
    }
    /**
     * Tells this objects spawner to create a number of new spawnables in the
     * game
     * @param amount the number of spawnables to be created
     * @param type the type of spawnable to be created
     */
    private void spawn(int amount, NodeType type) {
        spawner.spawn(amount, type);
    }
    
    /**
     * Returns the SpawnControl of the spawn point
     * @return the SpawnControl
     */
    public ISpawnControl getSpawnControl() {
        return spawner;
    }
    
}
