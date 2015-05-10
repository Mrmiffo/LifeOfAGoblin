/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

/**
 *
 * @author Anton
 */
public abstract class AbstractHostileNPC extends AbstractNPC /*implements IHostileBehaviour*/ {
    
    //private AbstractCharacter target;
    
    protected AbstractHostileNPC(String model, int health, int maxHealth){
        super(model, health, maxHealth);
    }
    
    /* IHostileBehaviour will extends IBehaviour and add:
     * public void hostileBehaviour()
     * 
     */
    
}
