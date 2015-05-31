package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.KeyNames;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import edu.chl.LifeOfAGoblin.model.profile.Keybind;

/**
 * A helper class to identify the display names of the different mouse and 
 * keyboard keys.
 * @author Anton
 */
public class KeyAndMouseNames {
    private static KeyAndMouseNames instance;
    private KeyNames keyNames;
    
    /**
     * Creates an instance of KeyAndMouseNames.
     */
    private KeyAndMouseNames(){
        keyNames = new KeyNames();
    }
    
    /**
     * Returns the singleton instance of KeyAndMouseNames.
     * @return the instance of KeyAndMouseNames
     */
    public static synchronized KeyAndMouseNames getInstance(){
        if (instance == null){
            instance = new KeyAndMouseNames();
        }
        return instance;
    }
    
    /**
     * A methods that translates a Keybind into a jME3 keyname.
     * @param keybind The keybind to translate
     * @return the name of the key.
     */
    public String getName(Keybind keybind){
        switch (keybind.getInputDevice()){
            case KEYBOARD:
                return keyNames.getName(keybind.getKey());
            case MOUSE_BUTTON:
                Trigger temp = new MouseButtonTrigger(keybind.getKey());
                return temp.getName();
            default:
                return "";
        }
    }
}
