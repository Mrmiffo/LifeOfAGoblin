/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IIdleBehaviour;

/**
 *
 * @author Anton
 */
public abstract class AbstractNPC extends AbstractCharacter implements IIdleBehaviour {
    protected AbstractNPC(String modelName, int health, int maxHealth){
        super(modelName, health, maxHealth);
    }
    
    @Override
    public void idleBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
