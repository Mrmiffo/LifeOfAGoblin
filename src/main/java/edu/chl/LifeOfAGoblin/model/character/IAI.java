package edu.chl.LifeOfAGoblin.model.character;

import edu.chl.LifeOfAGoblin.model.NodeType;

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
     * Updates the active action when the implementor collides with an object.
     * @param distance the distance to the collider.
     * @param direction the direction to the collider.
     * @param type the type of the collider.
     */
    public void updateAIAction(float distance, Direction direction, NodeType type);
}
