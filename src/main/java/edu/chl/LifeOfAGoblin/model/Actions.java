/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.util.HashMap;


/**
 * An enum describing all allowed actions, mapped to pairs of  Integer/InputDevice.
 * @author kakan
 */
public enum Actions {

    WALK_LEFT,
    WALK_RIGHT,
    JUMP,
    OPEN_MENU;
    private HashMap<Integer, InputDevice> keyCodes;

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
    public static Actions findActionByName(String actionString){
        switch (actionString){
            case "WALK_LEFT":
                return Actions.WALK_LEFT;
            case "WALK_RIGHT":
                return Actions.WALK_RIGHT;
            case "JUMP":
                return Actions.JUMP;
            case "OPEN_MENU":
                return Actions.OPEN_MENU;
            default:
                return null;
        }
    }
}
