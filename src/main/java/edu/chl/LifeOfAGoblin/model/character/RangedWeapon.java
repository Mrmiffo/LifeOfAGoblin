package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.ICollidable;

/**
 * A class representing a ranged weapon.
 * @author Ulrika
 */
public class RangedWeapon extends Weapon {
    
    /**
     * Creates a default ranged weapon.
     */
    public RangedWeapon() {
        this(2, 5);
    }
    
    /**
     * Creates a ranged weapon with a specified collision area and range.
     * @param collisionHeight the height of the collision area
     * @param collisionWidth the width of the collision area
     * @param range the range of the weapon
     */
    public RangedWeapon(float collisionHeight, float collisionWidth) {
        super(collisionHeight, collisionWidth);
    }

    @Override
    public void collide(ICollidable collided) {
    
    }
}
