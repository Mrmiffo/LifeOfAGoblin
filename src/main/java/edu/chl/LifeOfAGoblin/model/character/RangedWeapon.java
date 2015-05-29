/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.character;

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
    
}
