package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;


/**
 * The abstract inanimate object class is the super class for all objects in the
 * game that have a visual representaion but are not consider "living" 
 * (such as characters).
 * @author Anton
 */
public abstract class AbstractInanimateObject extends AbstractGameObject implements IModeledNode {
    protected String model;
    
   protected AbstractInanimateObject(String modelName) {
       this.model = modelName;
   }

    @Override
    public String getModelName() {
        return model;
    }

}
