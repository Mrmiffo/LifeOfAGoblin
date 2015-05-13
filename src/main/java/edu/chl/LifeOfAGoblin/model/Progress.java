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
    
    private int longestProgress, lastVisitedLevel, lastVisitedCheckpoint;
    
    public void update(int levelNbr, int checkpointNbr) {
        lastVisitedLevel = levelNbr;
        lastVisitedCheckpoint = checkpointNbr;
        if (longestProgress < levelNbr) {
            longestProgress = levelNbr;
        }
    }
}
