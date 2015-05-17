/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.util.HashMap;


/**
 *
 * @author kakan
 */

/**
 * Actions is an enum that contains all the possible actions that can be taken
 * by the player and maps them to a KeyTrigger.
 */
public enum Actions {

    WALK_LEFT("walkLeft"),
    WALK_RIGHT("walkRight"),
    JUMP("jump"),
    OPEN_MENU("openMenu");
    private final String keyBindText;
    private HashMap<Integer, InputDevice> keyCodes;

    Actions(String keyBindText) {
        this.keyBindText = keyBindText;
    }

    public String getKeyText() {
        return keyBindText;
    }

    public HashMap<Integer, InputDevice> getKeyCodes() {
        return (HashMap<Integer, InputDevice>)keyCodes.clone();
    }

    public void setKeyCodes(HashMap<Integer, InputDevice> newKeyCodes) {
        if (keyCodes != null) {
            keyCodes.clear();
        }
        keyCodes = (HashMap<Integer, InputDevice>)newKeyCodes.clone();
    }
}
