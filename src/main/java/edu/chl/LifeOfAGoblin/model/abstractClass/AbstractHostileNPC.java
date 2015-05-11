/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IHostileBehaviour;

/**
 *
 * @author Anton
 */
public abstract class AbstractHostileNPC extends AbstractNPC implements IHostileBehaviour {
    
    private final AbstractCharacter target; //The target to be hostile toward
    
    /**
     *
     * @param health
     * @param maxHealth
     * @param model
     * @param height
     * @param width
     * @param weight
     * @param baseDamage
     * @param baseArmour
     * @param target
     */
    protected AbstractHostileNPC(int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float baseArmour,
            AbstractCharacter target){
        
        super(maxHealth, model, height, width, weight, baseDamage, baseArmour);
        this.target = target;
    }
    
    @Override
    public void hostileBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
