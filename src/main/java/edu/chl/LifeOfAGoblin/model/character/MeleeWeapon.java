package edu.chl.LifeOfAGoblin.model.character;

/**
 * A class representing a melee weapon.
 * @author Ulrika
 */
public class MeleeWeapon extends Weapon {
    
    /**
     * Creates a default melee weapon.
     */
    public MeleeWeapon() {
        this(0.8f, 1);
    }
    
    /**
     * Creates a melee weapon with a specified collision area and range.
     * @param collisionHeight trhe height of the collision area
     * @param collisionWidth the width of the collision area
     * @param range the range of the weapon
     */
    public MeleeWeapon(float collisionHeight, float collisionWidth) {
        super(collisionHeight, collisionWidth);
    }
}
