/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import edu.chl.LifeOfAGoblin.model.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<Level> createdLevels;
    
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
        createdLevels = new ArrayList<>();
    }
    
    /**
     * Returns the selected level. If such a level doesn't exist, return null.
     * @param levelno
     * @return 
     */
    public synchronized Level getLevel(int levelno){
        Level toReturn = null;
        //First check if the level has already been loaded. If so: return it
        for (Level level: createdLevels){
            if (level.getLevelNo() == levelno){
                toReturn = level;
                break;
            }
        }
        //If the level has not loaded and it is a vali level: Create the level.
        if (toReturn == null && levelList.containsKey(levelno)){
            toReturn = new Level(levelList.get(levelno), levelno);
            createdLevels.add(toReturn);
        }
        return toReturn;
            
    }
        

    
    /**
     * Return the level that comes after the provided level. If the current 
     * level is the last level, will return null.
     * @param currentLevel
     * @return the next level.
     */
    public Level getNextLevel(Level currentLevel){
        return getLevel(currentLevel.getLevelNo()+1);
    }
    
    /**
     * Returns a list containing the names of all the levels in the game.
     * @return a list of all level names in level order.
     */
    public List<String> getAllLevelNames(){
        List<String> toReturn = new ArrayList<>();
        for (int i: levelList.keySet()){
            toReturn.add(levelList.get(i));
        }
        return toReturn;
    }


}
