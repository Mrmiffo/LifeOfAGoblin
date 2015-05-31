package edu.chl.LifeOfAGoblin.model.gameObject;

import edu.chl.LifeOfAGoblin.model.AbstractGameObject;
import edu.chl.LifeOfAGoblin.model.IModeledNode;


/**
 * The abstract inanimate object class is the abstraction of all objects in the
 * game that have a visual representaion but are not considered living.
 * @author Anton
 */
public abstract class AbstractInanimateObject extends AbstractGameObject implements IModeledNode {
   protected String model;
    
    /**
     *
     * @param modelName the name of the model.
     */
    protected AbstractInanimateObject(String modelName) {
       this.model = modelName;
   }

    @Override
    public String getModelName() {
        return model;
    }
}
