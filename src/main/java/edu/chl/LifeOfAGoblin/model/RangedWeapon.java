/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

/**
 *
 * @author Ulrika
 */
public class RangedWeapon extends Weapon {
    
    public RangedWeapon() {
        this(2, 20, 20);
    }
    
    public RangedWeapon(float collisionHeight, float collisionWidth, float range) {
        super(collisionHeight, collisionWidth, range);
    }
    
}
