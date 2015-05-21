package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;
import edu.chl.LifeOfAGoblin.model.Direction;

/**
 *
 * @author Anton
 */
public class PlayerMoveControl extends AbstractMoveControl implements IKeyListener{
    
    private final Actions[] actions = new Actions[] {
        Actions.JUMP, Actions.WALK_LEFT, Actions.WALK_RIGHT
    };

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
