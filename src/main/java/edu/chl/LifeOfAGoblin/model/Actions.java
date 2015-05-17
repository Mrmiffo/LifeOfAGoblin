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
    private final String description;
    private HashMap<Integer, InputDevice> keyCodes;

    Actions(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the enum.
     * @return the desctiption of the enum.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the key codes which invokes the enum.
     * @return a HashMap of Integer/InputDevices pairs that invoke the enum.
     */
    public HashMap<Integer, InputDevice> getKeyCodes() {
        return (HashMap<Integer, InputDevice>)keyCodes.clone();
    }

    /**
     * Replaces the current key codes of the enum with new ones.
     * @param newKeyCodes a HashMap of Integer/InputDevice pairs which will invoke the enum.
     */
    public void setKeyCodes(HashMap<Integer, InputDevice> newKeyCodes) {
        if (keyCodes != null) {
            keyCodes.clear();
        }
        keyCodes = (HashMap<Integer, InputDevice>)newKeyCodes.clone();
    }
}
