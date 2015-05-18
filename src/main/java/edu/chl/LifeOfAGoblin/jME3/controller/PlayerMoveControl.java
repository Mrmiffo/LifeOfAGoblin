package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;

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
                right = true;
            } else {
                right = false;
            }
        } else if (name.equals(Actions.WALK_LEFT.toString())){
            if (isPressed) {
                left = true;
            } else {
                left = false;
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
