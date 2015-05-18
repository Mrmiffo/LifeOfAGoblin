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

    WALK_LEFT,
    WALK_RIGHT,
    JUMP,
    OPEN_MENU;
    private HashMap<InputDevice, Integer> keyCodes;

    /**
     * Returns the key codes which invokes the enum.
     * @return a HashMap of Integer/InputDevices pairs that invoke the enum.
     */
    public HashMap<InputDevice, Integer> getKeyCodes() {
        return (HashMap<InputDevice, Integer>)keyCodes.clone();
    }

    /**
     * Replaces the current key codes of the enum with new ones.
     * @param newKeyCodes a HashMap of Integer/InputDevice pairs which will invoke the enum.
     */
    public void setKeyCodes(HashMap<InputDevice, Integer> newKeyCodes) {
        if (keyCodes != null) {
            keyCodes.clear();
        }
        keyCodes = (HashMap<InputDevice, Integer>)newKeyCodes.clone();
    }
}
