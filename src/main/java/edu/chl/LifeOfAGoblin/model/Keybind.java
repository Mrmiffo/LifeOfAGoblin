/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple class representing a mouse or keyboard keybind.
 * @author Anton
 */
public class Keybind implements Serializable{
    private InputDevice inputDevice;
    private int key;
    
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
        if (other.getClass() != Keybind.class){
            return false;
        } else if (this == other){
            return true;
        } else if (this.getInputDevice() == ((Keybind)other).getInputDevice() && this.getKey() == ((Keybind)other).getKey()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.inputDevice);
        hash = 73 * hash + this.key;
        return hash;
    }
}
