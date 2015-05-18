package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.Actions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anton
 */
public class PlayerMoveControl extends AbstractMoveControl implements IKeyListener{    

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(Actions.WALK_RIGHT.getDescription())){
            if (isPressed) {
                right = true;
            } else {
                right = false;
            }
        } else if (name.equals(Actions.WALK_LEFT.getDescription())){
            if (isPressed) {
                left = true;
            } else {
                left = false;
            }
        } else if (name.equals(Actions.JUMP.getDescription())){
            jump();
        }
    }

    @Override
    public List<Actions> getKeyBinds() {
        List<Actions> binds = new ArrayList<>();
        binds.add(Actions.JUMP);
        binds.add(Actions.WALK_LEFT);
        binds.add(Actions.WALK_RIGHT);
        return binds;
    }
}
