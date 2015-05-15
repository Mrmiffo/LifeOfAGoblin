/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractInanimateObject;

    
/**
 * The level model. Contains the model data of the level and the scene name.
 * @author Anton
 */
public class Level extends AbstractInanimateObject {
    private int levelNo;
    
    /**
     * Defaul contstructor for the level. Typically called from the LevelManager 
     * class. Takes the name of the level and the number of the level. These values
     * typcally only exist in the LevelManager class. The AbstractInanimate 
     * object class will use the level name to load the .j3o file. 
     * @param levelName the name of the level that should be created
     * @param levelno the player instance to load into the level.
     */
    public Level(String levelName, int levelNo){
        //Save the scene file to load.
        super(levelName+".j3o", "scenes");
        this.levelNo = levelNo;
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.LEVEL;
    }

    @Override
    public float getHeight() {
        return 1f; //is this really nessecary?
    }

    @Override
    public float getWidth() {
        return 1f; //is this really nessecary?
    }
    
    /**
     * An identical method to getModelName(), but with a more logical name.
     * @return the name of the level (same as model name).
     */
    public String getLevelName(){
        return getModelName();
    }
    
    /**
     * Returns the number of the level.
     * @return 
     */
    public int getLevelNo(){
        return levelNo;
    }
}
