/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

/**
 *
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter /*implements IBehaviour*/ {
    protected AbstractNPC(String modelName, int health, int maxHealth){
        super(modelName, health, maxHealth);
    }
    
    /*IBehaviour interface will have:
     * defaultBehaviour
     */
    
}
