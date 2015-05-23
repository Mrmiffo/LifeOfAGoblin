/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.model.NodeType;

/**
 * An interface descibing an object that can be referenced as a node.
 * @author Anton
 */
public interface INode {
    
    /**
     * Returns what type of node the implementor is.
     * @return the nodetype of the implementor.
     */
    public NodeType getNodeType(); //Is this needed? Node types are added directly to the Node in the current design(150515)...
    
    /**
     * Returns the height of the implementor's model.
     * @return the height of the model
     */
    public float getHeight(); //Should this method be part of the IModeledNode interface?
    
    /**
     * Returns the width of the implementor's model.
     * @return the width of the model.
     */
    public float getWidth(); //Should this method be part of the IModeldNode interface?
}
