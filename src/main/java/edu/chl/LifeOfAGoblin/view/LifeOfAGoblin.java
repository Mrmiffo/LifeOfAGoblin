/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.view;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.state.GameAppState;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;


/**
 *
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        
        //Start the game
        //TODO Replace with main menu.
        GameAppState gameState = new GameAppState();
        StateManagerWrapper.getInstance().addState(gameState);
    }
    
}
