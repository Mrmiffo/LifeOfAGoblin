/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;


/**
 * The abstract inanimate object class is the super class for all objects in the
 * game that have a visual represnetaion but are not consider "living" 
 * (such as characters).
 * @author Anton
 */
public abstract class AbstractInanimateObject extends AbstractGameObject implements IModeledNode {
    protected String model;
    
   protected AbstractInanimateObject(String modelName) {
       this.model = modelName;
       Resources.getInstance().loadResource(model, "models");
   }
   
   /**
    * A constructor used to speicfy the path for where the model i found. TYpicallu used for scenes.
    * @param modelName the name of the model.
    * @param otherPath the folder in which the model is located.
    */
   protected AbstractInanimateObject(String modelName, String otherPath){
        this.model = modelName;
        Resources.getInstance().loadResource(model, otherPath);
   }

    @Override
    public String getModelName() {
        return model;
    }

}
