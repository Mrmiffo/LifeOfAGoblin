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
    
    private final AbstractCharacter target;
    
    /**
     *
     * {@inheritDoc}
     * @param target the target that the NPC should be hostile toward
     */
    protected AbstractHostileNPC(int maxHealth, String model, float height,
            float width, float weight, float baseDamage, AbstractCharacter target){
        
        super(maxHealth, model, height, width, weight, baseDamage);
        this.target = target;
    }
    
    @Override
    public void hostileBehaviour() {
        //TODO add implementation
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
