/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractInanimateObject;
import edu.chl.LifeOfAGoblin.utils.NodeFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fredrik
 * A class that represents a node in the game that can update the 
 * progress class and that the player can respawn at.
 */
public class Checkpoint extends AbstractInanimateObject {
    private int level;
    private int number;
    private int height;
    private int width;
    private int depth;
    
    public Checkpoint(int level, int number, int height, int width, int depth){
        super();
        object.setUserData("objectType", "Checkpoint");
        this.level = level;
        this.number = number;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    
    @Override
    public NodeFactory.NodeType getNodeType() {
        return NodeFactory.NodeType.CHECKPOINT;
    }
    
        @Override
    public Map<String, Object> getNodeData() {
        Map<String, Object> nodeData = new HashMap<>();
        nodeData.put("level", level);
        nodeData.put("number", number);
        nodeData.put("width", width);
        nodeData.put("height", height);
        nodeData.put("depth", depth);        
        return nodeData;
    }
     
}
