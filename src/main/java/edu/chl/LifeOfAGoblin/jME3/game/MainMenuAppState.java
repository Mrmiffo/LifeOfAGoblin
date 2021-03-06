package edu.chl.LifeOfAGoblin.jME3.game;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.ProfileMenu;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.SettingsMenu;

/**
 * The mainMenuAppstate will create and display the main menu once activated.
 *
 * @author Anton
 */
public class MainMenuAppState extends AbstractAppState {

    private Application app;
    private AudioNode menuMusic;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        this.app = app;
        //Create an instance of the main menu, add it to nifty and display it.
        MainMenu mainMenu = new MainMenu();
        //For some reason the settings menu and profile menu are automatically added to nifty, but not the main menu...
        SettingsMenu settingsMenu = new SettingsMenu();
        ProfileMenu profileMenu = new ProfileMenu();
        NiftyGUIWrapper.getInstance().addScreen(mainMenu.getScreenName(), mainMenu.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(mainMenu.getScreenName());
        addMusic();

    }

    @Override
    public void cleanup() {
        super.cleanup();
        stopMusic();

    }

    private void addMusic() {
        menuMusic = (AudioNode) Resources.getInstance().getResources("prologue.wav");
        ((SimpleApplication) app).getRootNode().attachChild(menuMusic);
        menuMusic.setPositional(false);
        menuMusic.setLooping(true);
        menuMusic.setVolume(2);
        menuMusic.play();
    }

    private void stopMusic() {
        for (Spatial node : ((SimpleApplication) app).getRootNode().getChildren()) {
            if (node instanceof AudioNode) {
                ((AudioNode) node).stop();
            }
        }
    }
}
