/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.util.Map;


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
    private Map<Integer, InputDevice> keyCodes;

    Actions(String keyBindText) {
        this.keyBindText = keyBindText;
    }

    public String getKeyText() {
        return keyBindText;
    }

    public Map<Integer, InputDevice> getKeyCodes() {
        return keyCodes;
    }

    public void setKeyCodes(Map<Integer, InputDevice> newKeyCodes) {
        if (keyCodes != null) {
            keyCodes.clear();
        }
        keyCodes = newKeyCodes;
    }
}
