/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.io.Serializable;

/**
 *
 * @author kakan
 */
public class Progress implements Serializable {
    
    private int longestProgress;
    private int lastVisitedLevel;
    private int lastVisitedCheckpoint;
    
    //This should be called everytime the player activates a Checkpoint.
    public void update(int currentLevel, int currentCheckpoint) {
        lastVisitedLevel = currentLevel;
        lastVisitedCheckpoint = currentCheckpoint;
        if (longestProgress < currentLevel) {
            longestProgress = currentLevel;
        }
    }
    
    public int getLastVisitedLevel() {
        return lastVisitedLevel;
    }
    
    public int getLastVisitedCheckpoint() {
        return lastVisitedCheckpoint;
    }
    
    public int getLongestProgress() {
        return longestProgress;
    }
}
