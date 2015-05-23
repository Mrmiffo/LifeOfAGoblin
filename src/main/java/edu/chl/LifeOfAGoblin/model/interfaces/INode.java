/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

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
}
