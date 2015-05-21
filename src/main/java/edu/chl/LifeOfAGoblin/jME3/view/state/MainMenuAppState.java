package edu.chl.LifeOfAGoblin.jME3.view.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.ProfileMenu;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.SettingsMenu;

/**
 *
 * @author Anton
 */
public class MainMenuAppState extends AbstractAppState{

    private Application app;
    private AudioNode menuMusic;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        this.app = app;
        //Create an instance of the main menu, add it to nifty and display it.
        MainMenu mainMenu = new MainMenu();
        SettingsMenu settingsMenu = new SettingsMenu();
        ProfileMenu profileMenu = new ProfileMenu();
        NiftyGUIWrapper.getInstance().addScreen(mainMenu.getScreenName(), mainMenu.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(mainMenu.getScreenName());
        addMusic();
        
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        for (Spatial node: ((SimpleApplication)app).getRootNode().getChildren()){
            if (node instanceof AudioNode){
                ((SimpleApplication)app).getRootNode().detachChild(node);
            }
        }

    }

    private void addMusic() {
//        Resources.getInstance().loadResource("prologue.mp3", "sounds");
//        menuMusic = (AudioNode)Resources.getInstance().getResources("prologue.mp3");
//        ((SimpleApplication)app).getRootNode().attachChild(menuMusic);
    }
}
