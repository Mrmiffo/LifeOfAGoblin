/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.factory.NodeType;
import java.util.Map;

/**
 *
 * @author Anton
 */
public interface INode {
    public Map<String, Object> getNodeData();
    public NodeType getNodeType();
}
