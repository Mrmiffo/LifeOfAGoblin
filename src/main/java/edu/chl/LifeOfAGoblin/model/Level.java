/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;

/**
 * The level model. Contains the model data of the level and the scene name.
 * @author Anton
 */
public class Level implements IModeledNode{
    private String scene;
    private Player player;
    
    /**
     * Creates and stores a scene with a specified name and adds all wanted objects to the scene.
     * 
     * @param levelName the name of the level that should be created
     */
    
    public Level(String levelName, Player player){
        //Save the scene file to load.
        scene = levelName;
        this.player = player;

    }
    
    @Override
    public String getModelName() {
        return scene;
    }


    @Override
    public NodeType getNodeType() {
        return NodeType.LEVEL;
    }
    
    public Player getPlayer(){
        return player;
    }
}
