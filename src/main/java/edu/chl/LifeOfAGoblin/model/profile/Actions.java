package edu.chl.LifeOfAGoblin.model.profile;

import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import java.util.ArrayList;


/**
 * An enum describing all allowed actions, mapped to currently active keybinds.
 * @author Anton
 */
public enum Actions {

    WALK_LEFT,
    WALK_RIGHT,
    JUMP,
    OPEN_MENU;
    private ArrayList<Keybind> keyCodes;

    /**
     * Returns the keybinds which invokes the action.
     * @return a HashMap of Integer/InputDevices pairs that invoke the enum.
     */
    public ArrayList<Keybind> getKeyCodes() {
        return (ArrayList<Keybind>)keyCodes.clone();
    }

    /**
     * Replaces the current keybinds of the action with new ones. Also registers 
     * the action to the InputManagerWrapper.
     * @param newKeyCodes a HashMap of Integer/InputDevice pairs which will invoke the enum.
     */
    public void setKeyCodes(ArrayList<Keybind> newKeyCodes) {
        if (keyCodes != null) {
            keyCodes.clear();
        }
        keyCodes = (ArrayList<Keybind>)newKeyCodes.clone();
        InputManagerWrapper.getInstance().registerAction(this);
    }
    
    /**
     * A method used to get the enum of a specific string. Typically used in the 
     * GUI where Nifty XML does not allow java code but only strings.
     * @param actionString the string of the action
     * @return the action related to the string. If no such action exist will return null.
     */
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
