/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class conatins a list of all the levels in the game. All requests for 
 * the level model should be done from this class. Levels will not be created 
 * with the LevelManager class, but will instead be created once they are needed 
 * to save memory.
 * @author Anton
 */
public class LevelManager {
    private Map<Integer, String> levelList;
    private static LevelManager instance;
    private LevelManager(){
        
    }
    
    public static synchronized LevelManager getInstance(){
        if (instance == null){
            instance = new LevelManager();
        }
        return instance;
    }
    
    /**
     * Initialize the levelList. No Level objects will be created until a get 
     * method is called
     */
    public void initialize(){
        levelList = new HashMap<>();
        levelList.put(1, "Level1");
        levelList.put(2, "testScene");
    }
    
    /**
     * Returns the selected level. If such a level doesn't exist, return null.
     * @param levelno
     * @return 
     */
    public Level getLevel(int levelno){
        return null;
    }
    
    /**
     * Return the level that comes after the provided level. If the current 
     * level is the last level, will return null.
     * @param currentLevel
     * @return the next level.
     */
    public Level getNextLevel(Level currentLevel){
        return null;
    }
}
