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
    
    private AbstractCharacter target; //target to be hostile against
    
    protected AbstractHostileNPC(String model, int health, int maxHealth){
        super(model, health, maxHealth);
    }
    
    @Override
    public void hostileBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
