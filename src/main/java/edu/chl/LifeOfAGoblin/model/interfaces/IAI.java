/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model.interfaces;

import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.AIAction;

/**
 *
 * @author Ulrika
 */
public interface IAI {
    
    /**
     * Returns the currently active type of AIAction.
     * @return the active AIAction
     */
    public AIAction getAIAction();
    
    /**
     * Updates the active action when no collisions are found.
     */
    public void updateAIAction();
    
    /**
     * Recieves the distance to a specified object and the object's NodeType and
     * updates the active action accordingly. The direction can be either left or right.
     */
    public void updateAIAction(float distance, String direction, NodeType type);
}
