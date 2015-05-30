package edu.chl.LifeOfAGoblin.utils;

import edu.chl.LifeOfAGoblin.model.gameObject.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class conatins a list of all the levels in the game. All requests for 
 * the level model should be done from this class. 
 * @author Anton
 */
public class LevelManager {
    private HashMap<Integer, Level> levelList;
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
     * Initialize the levelList. 
     */
    public void initialize(){
        levelList = new HashMap<>();
        levelList.put(1, new Level("Level1",1, "magical_theme.wav"));
        levelList.put(2, new Level("Level2", 2, "magical_theme.wav"));
    }
    
    /**
     * Returns the selected level. If such a level doesn't exist, return null.
     * @param levelno
     * @return 
     */
    public synchronized Level getLevel(int levelno){
        Level toReturn = null;
        //First check if the level has already been loaded. If so: return it
        for (int level: levelList.keySet()){
            if (level == levelno){
                toReturn = levelList.get(level);
                break;
            }
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
            toReturn.add(levelList.get(i).getLevelName());
        }
        return toReturn;
    }


}
