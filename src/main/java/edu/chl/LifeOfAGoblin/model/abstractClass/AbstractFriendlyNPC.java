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
    protected AbstractFriendlyNPC(String model, int health, int maxHealth){
        super(model, health, maxHealth);
    }
    
    @Override
    public void friendlyBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
