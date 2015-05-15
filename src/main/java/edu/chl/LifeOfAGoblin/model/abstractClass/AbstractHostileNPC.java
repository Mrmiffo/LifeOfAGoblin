/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.interfaces.IHostileBehaviour;

/**
 * Is this needed?
 * @author Anton
 */
public abstract class AbstractHostileNPC extends AbstractNPC implements IHostileBehaviour {
    
    private NodeType target;
    private float aggresitionRange;
    
    /**
     *
     * {@inheritDoc}
     * @param target the target that the NPC should be hostile toward
     */
    protected AbstractHostileNPC(int maxHealth, String model, float height, float width,
            float weight, float baseDamage, float jumpStrength, NodeType target){
        
        super(maxHealth, model, height, width, weight, baseDamage, jumpStrength);
        this.target = target;
    }
    
    @Override
    public void hostileBehaviour() {
        //TODO add implementation
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
