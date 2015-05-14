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
    
    private Level longestProgress;
    private Level lastVisitedLevel;
    private Checkpoint lastVisitedCheckpoint;
    
    public void update(Level currentLevel, Checkpoint currentCheckpoint) {
        lastVisitedLevel = currentLevel;
        lastVisitedCheckpoint = currentCheckpoint;
        if (LevelList.getPosition(longestProgress) < LevelList.getPosition(currentLevel)) {
            longestProgress = currentLevel;
        }
    }
}
