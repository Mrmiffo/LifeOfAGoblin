package edu.chl.LifeOfAGoblin.jME3.view;

import com.jme3.app.SimpleApplication;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.utils.SaveLoadManager;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.state.MainMenuAppState;
import edu.chl.LifeOfAGoblin.archive.PauseAppState;
import edu.chl.LifeOfAGoblin.model.Profile;
import edu.chl.LifeOfAGoblin.utils.LevelManager;
import java.util.List;


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
            Profile.setActiveProfile(defaultProfile);
        } else {
            for (String fileName: allSavedFiles){
                Profile tempProfile = (Profile) SaveLoadManager.getInstance().loadFile(null, fileName);
                Profile.addProfile(tempProfile);
                if (tempProfile.getIsActiveProfile()){
                    Profile.setActiveProfile(tempProfile);
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
        PauseAppState pauseState = new PauseAppState();
        MainMenuAppState mainMenu = new MainMenuAppState();
        StateManagerWrapper.getInstance().addState(gameState);
        StateManagerWrapper.getInstance().addState(pauseState);
        StateManagerWrapper.getInstance().addState(mainMenu);
        StateManagerWrapper.getInstance().activateState(gameState);
//        StateManagerWrapper.getInstance().deactivateState(gameState);
    }
}
