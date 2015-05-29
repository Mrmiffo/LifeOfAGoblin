package edu.chl.LifeOfAGoblin.model.profile;

import java.io.Serializable;

/**
 *
 * @author kakan
 */
public class Progress implements Serializable {
    
    private int longestProgress;
    private int lastVisitedLevel;
    private int lastVisitedCheckpoint;
    private static final long serialVersionUID = -9078773734400478680L;
    
    //This should be called everytime the player activates a Checkpoint.
    /**
     * Updates the progress with the given parameters.
     * @param currentLevel the level the player is on.
     * @param currentCheckpoint the checkpoint the player is at.
     */
    public void update(int currentLevel, int currentCheckpoint) {
        lastVisitedLevel = currentLevel;
        lastVisitedCheckpoint = currentCheckpoint;
        if (longestProgress < currentLevel) {
            longestProgress = currentLevel;
        }
    }
    
    /**
     * Returns the last level the player was on.
     * @return the last level the player visited.
     */
    public int getLastVisitedLevel() {
        return lastVisitedLevel;
    }
    
    /**
     * Returns the last checkpoint the player was at.
     * @return the last checkpoint the player visited.
     */
    public int getLastVisitedCheckpoint() {
        return lastVisitedCheckpoint;
    }
    
    /**
     * Returns the furthest level the player has reached.
     * @return the furthest level the player has reached.
     */
    public int getLongestProgress() {
        return longestProgress;
    }
}
