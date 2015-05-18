/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller.interfaces;

import com.jme3.input.controls.ActionListener;
import edu.chl.LifeOfAGoblin.model.Actions;

/**
 * An interface used when registering an actionlistener to the inputManager.
 * @author Anton
 */
public interface IKeyListener extends ActionListener {
    /*
     * This method will provide all the KeyBinding.KeyBind that the specified 
     * actionlistener wish to listen to. Used when registering the 
     * actionlistener to the inputManager.
     */
    public Actions[] getKeyBinds();
}
