/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;


/**
 *
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        NiftyGUIWrapper.getInstance().initialize(this);
        
        //Start the game
        //TODO Replace with main menu.
        GameAppState gameState = new GameAppState();
        StateManagerWrapper.getInstance().addState(gameState);
    }
    
}
