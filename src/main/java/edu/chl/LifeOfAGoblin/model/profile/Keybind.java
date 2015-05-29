package edu.chl.LifeOfAGoblin.model.profile;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple class representing a mouse or keyboard keybind.
 * @author Anton
 */
public class Keybind implements Serializable{
    private InputDevice inputDevice;
    private int key;
    private static final long serialVersionUID = -1499800738716923957L;
    
    /**
     * The basic constructor of Keybind. Will create an immutable Keybind object.
     * @param inputDevice the input device, mouse or keyboard connected to the key.
     * @param key the int of the mouse or keyboard key.
     */
    public Keybind(InputDevice inputDevice, int key){
        this.inputDevice = inputDevice;
        this.key = key; 
    }
    
    public InputDevice getInputDevice(){
        return inputDevice;
    }
    
    public int getKey(){
        return key;
    }
    
    
    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        
        if (other == null) {
            return false;
        }
        
        if (other.getClass() != this.getClass()) {
            return false;
        }
        
        Keybind otherKeybind = (Keybind)other;
        return this.getInputDevice() == (otherKeybind.getInputDevice()) &&
                this.getKey() == otherKeybind.getKey();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.inputDevice);
        hash = 73 * hash + this.key;
        return hash;
    }
}
