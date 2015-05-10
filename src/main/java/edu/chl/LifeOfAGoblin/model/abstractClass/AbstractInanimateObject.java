/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.abstractClass;

import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;


/**
 *
 * @author Anton
 */
public abstract class AbstractInanimateObject implements INode, IModeledNode {
    protected Node object;
    protected String model;
    
   protected AbstractInanimateObject(String modelName) {
       object = (Node) Resources.getInstance().getResources(modelName);
       this.model = modelName;
   }

    @Override
    public String getModelName() {
        return model;
    }

    @Override
    public NodeType getNodeType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
