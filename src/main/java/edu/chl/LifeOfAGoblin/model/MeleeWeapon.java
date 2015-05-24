/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

/**
 * A class representing a melle weapon.
 * @author Ulrika
 */
public class MeleeWeapon extends Weapon {
    
    /**
     * Creates a default melee weapon.
     */
    public MeleeWeapon() {
        this(1, 1, 1);
    }
    
    /**
     * Creates a melee weapon with a specified collision area and range.
     * @param collisionHeight trhe height of the collision area
     * @param collisionWidth the width of the collision area
     * @param range the range of the weapon
     */
    public MeleeWeapon(float collisionHeight, float collisionWidth, float range) {
        super(collisionHeight, collisionWidth, range);
    }
}
