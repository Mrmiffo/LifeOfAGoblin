/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

/**
 * An interface for all killable characters.
 * @author kakan
 */
public interface IKillable {
    
    /**
     * Is called when the inheritor dies.
     */
    public void die();
    
    /**
     * Sets whether the implementor is dead or not.
     * @param b whether the implementor is dead or not.
     */
    public void setIsDead(boolean b);
    
    /**
     * Returns whether the implementor is dead or not.
     * @return whether the implementor is dead or not.
     */
    public boolean isDead();
}
