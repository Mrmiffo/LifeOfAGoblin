/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.view;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.SettingsMenu;
import edu.chl.LifeOfAGoblin.utils.LevelManager;


/**
 * The LifeOfAGoblin class is the game itself. This class will insitialize all 
 * needed singletons and extends the jME3 simple Application. During use the start()
 * method to run the game and the user will be presented with the main menu.
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        //Initialize the game singleton instances.
        NiftyGUIWrapper.getInstance().initialize(this);
        InputManagerWrapper.initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
        LevelManager.getInstance().initialize();
        
        //Create an instance of the main menu, add it to nifty and display it.
        MainMenu mainMenu = new MainMenu();
        SettingsMenu settingsMenu = new SettingsMenu();
        NiftyGUIWrapper.getInstance().addScreen(mainMenu.getScreenName(), mainMenu.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(mainMenu.getScreenName());
        
        //Disables the built-in flyCam
        this.flyCam.setEnabled(false);
    }
    
}
