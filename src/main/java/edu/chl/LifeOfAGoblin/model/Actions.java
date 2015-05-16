/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;

/**
 *
 * @author kakan
 */

/**
 * Actions is an enum that contains all the possible actions that can be taken
 * by the player and maps them to a KeyTrigger.
 */
public enum Actions {

    WALK_LEFT("walkLeft", new Trigger[]{new KeyTrigger(KeyInput.KEY_A)}),
    WALK_RIGHT("walkRight", new Trigger[]{new KeyTrigger(KeyInput.KEY_D)}),
    JUMP("jump", new Trigger[]{
        //new MouseButtonTrigger(MouseInput.BUTTON_LEFT),
        new KeyTrigger(KeyInput.KEY_W),
        new KeyTrigger(KeyInput.KEY_SPACE)
    }),
    OPEN_MENU("openMenu", new Trigger[]{new KeyTrigger(KeyInput.KEY_P), new KeyTrigger(KeyInput.KEY_ESCAPE)});
    private final String keyBindText;
    private Trigger[] triggers;

    Actions(String keyBindText, Trigger[] triggers) {
        this.keyBindText = keyBindText;
        this.triggers = triggers;
    }

    public String getKeyText() {
        return keyBindText;
    }

    public Trigger[] getTriggers() {
        return triggers;
    }

    public void setTriggers(Trigger[] triggers) {
        this.triggers = triggers;
    }
}
