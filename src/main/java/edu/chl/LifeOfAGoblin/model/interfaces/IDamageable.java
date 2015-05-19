/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

/**
 * Interface to be implemented by all damageable entities. A delay between each
 * time the entity receives damage is created by a boolean, because of the difference
 * between user and computer reaction time.
 * @author Ulrika
 */

public interface IDamageable {
    
    /**
     * Sets whether this object can be damaged or not.
     * @param b whether the object can be damaged or not
     */
    public void setIsInvulnerable(boolean b);   
   
   
    /**
     * Returns whether this object can be damaged or not.
     * @return whether the object can be damaged or not
     */
    public boolean getIsInvulnerable();
   
    /**
     * Called when this object takes damage.
     * @param pointsOfDamageTaken the amount of damage recieved.
     */
    public void recieveDamage(int pointsOfDamageTaken);
}
