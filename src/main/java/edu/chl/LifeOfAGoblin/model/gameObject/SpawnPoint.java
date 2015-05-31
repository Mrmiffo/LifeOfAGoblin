package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import edu.chl.LifeOfAGoblin.model.ISpawnable;


/**
 * A class representing a spawnpoint that is responsible for creating new 
 * spawnables in the game when a player collides with it.
 * @author fredrik
 */
public class SpawnPoint extends AbstractGameObject implements ICollidable, IActivatable {
    
    private final static float height = 100;
    private int amount;
    private boolean activated;
    private float width;
    private Class<? extends ISpawnable> spawnType;
    
     /**
     * Constructor for creating a Spawnpoint
     * @param spawner the control responsible for creating the spawnables
     * @param amount how many spawnable should spawn
     * @param type what type of spawnable should spawn
     */
     public SpawnPoint(int amount, Class<? extends ISpawnable> spawnType, float width) {
         this.amount = amount;
         this.spawnType = spawnType;
         this.width = width;
    }

    /**
     * Is called when a player collides with the Spawnpoint. Runs spawn with 
     * this object's amount and type and sets IsActivated to true
     */
    @Override
    public void collide(ICollidable collided) {
        if (!activated && collided.getClass() == Player.class) {
            spawn();
        }
    }
    /**
     * Tells this objects spawner to create a number of new spawnables in the
     * game
     * @param amount the number of spawnables to be created
     * @param type the type of spawnable to be created
     */
    private void spawn() {
        this.activate();
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
    
    public Class<? extends ISpawnable> getType(){
        return this.spawnType;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
}
