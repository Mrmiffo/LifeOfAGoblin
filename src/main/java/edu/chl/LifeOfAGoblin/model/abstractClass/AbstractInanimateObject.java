/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.utils.Resources;


/**
 *
 * @author Anton
 */
public abstract class AbstractInanimateObject {
    protected Node object;
    
   protected AbstractInanimateObject(String modelName) {
       object = (Node) Resources.getInstance().getResources(modelName);
   }
}
