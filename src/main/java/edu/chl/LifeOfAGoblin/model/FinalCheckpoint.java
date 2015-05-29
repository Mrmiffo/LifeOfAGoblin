package edu.chl.LifeOfAGoblin.model;

import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.model.interfaces.ICollidable;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.state.MainMenuAppState;


/**
 * A class representing a checkpoint that is the last checkpoint in the game
 * and when the player collides with the checkpoint the level is completed.
 * @author fredrik
 */
public class FinalCheckpoint extends Checkpoint {
    private int level;
    private int number;
    public FinalCheckpoint(int level, int number, float width){
        super(level, number, width);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.FINALCHECKPOINT;
    }
    
     /**
     * Is called when an ICollidable collides with this finalCheckpoint. Runs 
     * updateProgress with this object's level and number, sets 
     * IsActivated to true and tells the level to end if the object is a Player.
     */
    @Override
    public void collide(ICollidable collided) {
        super.collide(collided);
        
        //TODO fix this properly
//            StateManagerWrapper.getInstance().deactivateState(StateManagerWrapper.getInstance().getAvailableState(GameAppState.class));
//            StateManagerWrapper.getInstance().activateState(StateManagerWrapper.getInstance().getAvailableState(MainMenuAppState.class));
    }
}
