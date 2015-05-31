package edu.chl.LifeOfAGoblin.utils;

import com.jme3.input.controls.ActionListener;
import edu.chl.LifeOfAGoblin.model.profile.Actions;

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
