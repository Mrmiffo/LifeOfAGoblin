package edu.chl.LifeOfAGoblin.jME3.character;

import edu.chl.LifeOfAGoblin.utils.IKeyListener;
import edu.chl.LifeOfAGoblin.model.profile.Actions;
import edu.chl.LifeOfAGoblin.model.character.Direction;

/**
 * The player move control listens for keyaction related to movement and tell the 
 * character which way to move. The actual moving of the character is done in the 
 * super class AbstractMoveControl
 * @author kakan
 */
public class PlayerMoveControl extends AbstractMoveControl implements IKeyListener{
    
    //Declare which actions the control listen for.
    private final Actions[] actions = new Actions[] {
        Actions.JUMP, Actions.WALK_LEFT, Actions.WALK_RIGHT
    };

    //Translate action to movement command.
    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(Actions.WALK_RIGHT.toString())){
            if (isPressed) {
                //right = true;
                currentDirection = Direction.RIGHT;
            } else {
                //right = false;
                currentDirection = Direction.STAND_STILL;
            }
        } else if (name.equals(Actions.WALK_LEFT.toString())){
            if (isPressed) {
                //left = true;
                currentDirection = Direction.LEFT;
            } else {
                //left = false;
                currentDirection = Direction.STAND_STILL;
            }
        } else if (name.equals(Actions.JUMP.toString())){
            jump();
        }
    }

    @Override
    public Actions[] getKeyBinds() {
        return (Actions[])actions.clone();
    }
}
