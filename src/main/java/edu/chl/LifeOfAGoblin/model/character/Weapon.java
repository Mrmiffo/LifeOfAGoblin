package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.ICollidable;


/**
 * The abstraction of all weapons.
 * @author Ulrika
 */
public abstract class Weapon extends AbstractGameObject implements ICollidable {

    private float collisionHeight;
    private float collisionWidth;
    
    /**
     * 
     * @param collisionHeight the height within which the weapon can collide. 
     * @param collisionWidth the width within which the weapon can collide.
     */
    public Weapon(float collisionHeight, float collisionWidth) {
        this.collisionHeight = collisionHeight;
        this.collisionWidth = collisionWidth;
    }

    @Override
    public float getCollisionHeight() {
        return collisionHeight;
    }

    @Override
    public float getCollisionWidth() {
        return collisionWidth;
    }
}
