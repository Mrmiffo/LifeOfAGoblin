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
    
    /**
     *
     * {@inheritDoc}
     */
    protected AbstractFriendlyNPC(int maxHealth, String model, float height,
            float width, float weight, float baseDamage){
        
        super(maxHealth, model, height, width, weight, baseDamage);
    }
    
    @Override
    public void friendlyBehaviour() {
        //TODO add implementation
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
