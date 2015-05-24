package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.interfaces.IActivatable;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnControl;

/**
 * A class representing a spawnpoint that is responsible for creating new 
 * spawnables in the game when a player collides with it.
 * @author fredrik
 */
public class SpawnPoint extends AbstractGameObject implements ICollidable, IActivatable {
    
    private final static float height = 100;
    private int amount;
    private NodeType type;
    private ISpawnControl spawner;
    private boolean activated;
    private float width;
    
     /**
     * Constructor for creating a Spawnpoint
     * @param spawner the control responsible for creating the spawnables
     * @param amount how many spawnable should spawn
     * @param type what type of spawnable should spawn
     */
     public SpawnPoint(ISpawnControl spawner, int amount, NodeType type, float width) {
         this.spawner = spawner;
         this.amount = amount;
         this.type = type;
         this.width = width;
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
    public void collide(ICollidable collided) {
        if (!activated && collided.getClass() == Player.class) {
            spawn(amount, type);
            this.activate();
        }
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

    @Override
    public boolean isActivated() {
        return activated;
    }

    @Override
    public void activate() {
        activated = true;
    }

    @Override
    public void inactivate() {
        activated = false;
    }

    @Override
    public float getCollisionHeight() {
        return height;
    }

    @Override
    public float getCollisionWidth() {
        return width;
    }
    
}
