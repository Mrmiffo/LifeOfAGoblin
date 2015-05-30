package edu.chl.LifeOfAGoblin.jME3.game;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.model.profile.Profile;
import edu.chl.LifeOfAGoblin.utils.LevelManager;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The LifeOfAGoblin class is the game itself. This class will insitialize all 
 * needed singletons and extends the jME3 simple Application. Use the start()
 * method to run the game and the user will be presented with the main menu.
 * This will also run all the initialize methods for all the helper classes.
 * @author Anton
 */
public class LifeOfAGoblin extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        //Initialize the game singleton instances.
        NiftyGUIWrapper.getInstance().initialize(this);
        InputManagerWrapper.getInstance().initialize(inputManager);
        StateManagerWrapper.getInstance().initialize(stateManager);
        Resources.getInstance().initialize(assetManager);
        LevelManager.getInstance().initialize();
        PhysicsWrapper.getInstance();
        setupProfile();
        setupAppStates();
        
        StateManagerWrapper.getInstance().activateState(StateManagerWrapper.getInstance().getAvailableState(MainMenuAppState.class));
        
        //Removes statistics
        setDisplayFps(false);
        setDisplayStatView(false);

        //Disables the built-in flyCam
        this.flyCam.setEnabled(false);
    }

    /**
     * Metod to load saved profiles into the static profile list.
     */
    private void setupProfile() {
        List<String> allSavedFiles = SaveLoadManager.getInstance().getSavedFiles(null);
        if (allSavedFiles.isEmpty()){
            Profile defaultProfile = new Profile("Default profile");
            Profile.addProfile(defaultProfile);
            try {
                Profile.setActiveProfile(defaultProfile);
            } catch (IOException ex) {
                //TODO Add error message
                System.out.println("Life Of a Goblin IO ERROR: Unable to save profile");
            }
        } else {
            for (String fileName: allSavedFiles){
                Serializable temp;
                try {
                    temp = SaveLoadManager.getInstance().loadFile(null, fileName);
                } catch (IOException | ClassNotFoundException io) {
                    temp = null;
                } 
                if (temp != null && temp instanceof Profile){
                    Profile tempProfile = (Profile)temp;
                    Profile.addProfile(tempProfile);
                    if (tempProfile.getIsActiveProfile()){
                        try {
                            Profile.setActiveProfile(tempProfile);
                        } catch (IOException ex) {
                            //TODO Add error message
                            System.out.println("Life Of a Goblin IO ERROR: Unable to load profile");
                        }
                    }
                }

            }
        }
    }

    /**
     * A method to setup the app states and register them to the list of available 
     * states in the state manager.
     */
    private void setupAppStates() {
        GameAppState gameState = new GameAppState();
        MainMenuAppState mainMenu = new MainMenuAppState();
        StateManagerWrapper.getInstance().addState(gameState);
        StateManagerWrapper.getInstance().addState(mainMenu);
        StateManagerWrapper.getInstance().activateState(gameState);
//        StateManagerWrapper.getInstance().deactivateState(gameState);
    }
}
