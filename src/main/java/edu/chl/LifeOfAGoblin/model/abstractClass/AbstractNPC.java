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
    protected AbstractNPC(int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float baseArmour){
        
        super(maxHealth, model, height, width, weight, baseDamage, baseArmour);
    }
    
    @Override
    public void idleBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
