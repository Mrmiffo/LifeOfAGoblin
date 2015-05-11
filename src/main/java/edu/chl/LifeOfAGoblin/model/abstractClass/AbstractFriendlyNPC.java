/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IFriendlyBehaviour;

/**
 *
 * @author Anton
 */
public abstract class AbstractFriendlyNPC extends AbstractNPC implements IFriendlyBehaviour {
    protected AbstractFriendlyNPC(int health, int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float baseArmour){
        
        super(health, maxHealth, model, height, width, weight, baseDamage, baseArmour);
    }
    
    @Override
    public void friendlyBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
