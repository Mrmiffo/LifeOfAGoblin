/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.interfaces.IHostileBehaviour;

/**
 *
 * @author Anton
 */
public abstract class AbstractHostileNPC extends AbstractNPC implements IHostileBehaviour {
    
    private final AbstractCharacter target;
    
    protected AbstractHostileNPC(int health, int maxHealth, String model, float height,
            float width, float weight, float baseDamage, float baseArmour,
            AbstractCharacter target){
        
        super(health, maxHealth, model, height, width, weight, baseDamage, baseArmour);
        this.target = target;
    }
    
    @Override
    public void hostileBehaviour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
