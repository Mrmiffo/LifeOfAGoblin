package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.controller.interfaces.IKeyListener;
import edu.chl.LifeOfAGoblin.model.KeyBindings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anton
 */
public class PlayerMoveControl extends AbstractMoveControl implements IKeyListener{    

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals(KeyBindings.KeyBind.WALK_RIGHT.getKeyText())){
            if (isPressed) {
                right = true;
            } else {
                right = false;
            }
        } else if (name.equals(KeyBindings.KeyBind.WALK_LEFT.getKeyText())){
            if (isPressed) {
                left = true;
            } else {
                left = false;
            }
        } else if (name.equals(KeyBindings.KeyBind.JUMP.getKeyText())){
            playerControl.jump();
        }
    }

    @Override
    public List<KeyBindings.KeyBind> getKeyBinds() {
        List<KeyBindings.KeyBind> binds = new ArrayList<>();
        binds.add(KeyBindings.KeyBind.JUMP);
        binds.add(KeyBindings.KeyBind.WALK_LEFT);
        binds.add(KeyBindings.KeyBind.WALK_RIGHT);
        return binds;
    }
}
