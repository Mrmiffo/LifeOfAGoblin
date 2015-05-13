/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;


/**
 *
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        //Camera
        NiftyGUIWrapper.getInstance().initialize(this);
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
        
//        GameAppState playGame = new GameAppState();
        MainMenu mainMenu = new MainMenu();
        NiftyGUIWrapper.getInstance().addScreen(mainMenu.getScreenName(), mainMenu.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(mainMenu.getScreenName());
        
        //Disables the built-in flyCam
        this.flyCam.setEnabled(false);
        //this.getFlyByCamera().setDragToRotate(true);
    }
    
}
