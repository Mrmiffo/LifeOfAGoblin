/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

/**
 *
 * @author Anton
 */
public interface INode {
    /**
     * Is this needed? Node types are added directly to the Node in the current design(150515)...
     * @return 
     */
    public NodeType getNodeType();
    /**
     * Returns the height of the model.
     * Should this method be part of the IModeledNode interface?
     * @return 
     */
    public float getHeight();
    /**
     * Returns the width of the model.
     * Should this method be part of the IModeldNode interface?
     * @return 
     */
    public float getWidth();
}
