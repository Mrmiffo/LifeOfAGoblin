/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.factory.NodeType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anton
 */
public class Level implements IModeledNode{
    private String scene;
    
    /**
     * Creates and stores a scene with a specified name and adds all wanted objects to the scene.
     * 
     * @param levelName the name of the level that should be created
     */
    
    public Level(String levelName){
        //Save the scene file to load.
        scene = levelName;

    }
    
    @Override
    public String getModel() {
        return scene;
    }

    @Override
    public Map<String, Object> getNodeData() {
        Map<String, Object> nodeData = new HashMap<>();
        
        return nodeData;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LEVEL;
    }
}
