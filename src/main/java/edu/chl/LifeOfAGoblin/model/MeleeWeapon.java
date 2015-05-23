/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

/**
 *
 * @author Ulrika
 */
public class MeleeWeapon extends Weapon {
    public MeleeWeapon() {
        this(1, 20, 10);
    }
    
    public MeleeWeapon(float collisionHeight, float collisionWidth, float range) {
        super(collisionHeight, collisionWidth, range);
    }
}
