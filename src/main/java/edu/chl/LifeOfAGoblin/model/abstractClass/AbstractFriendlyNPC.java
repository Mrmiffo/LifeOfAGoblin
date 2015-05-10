/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

/**
 *
 * @author Anton
 */
public abstract class AbstractFriendlyNPC extends AbstractNPC /*implements IFriendlyBehaviour*/ {
    protected AbstractFriendlyNPC(String model, int health, int maxHealth){
        super(model, health, maxHealth);
    }
    
    /*IFriendlyBehaviour extends IBehaviour and adds:
     * public void friendlyBehaviour()
     * 
     */
}
