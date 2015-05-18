/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

/**
 *
 * @author kakan
 */
public interface IKillable {
    
    /**
     * Is called when the inheritor dies.
     */
    public void die();
    public void setIsDead(boolean isDead);
    public boolean getIsDead();

    
    
}
