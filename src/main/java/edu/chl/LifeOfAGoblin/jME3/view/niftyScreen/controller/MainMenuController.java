package edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller;


import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ImageSelect;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.main.Main;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.GameHud;
import edu.chl.LifeOfAGoblin.jME3.view.state.MainMenuAppState;
import java.util.List;

/**
 * The MainMenuController is the control class for the main menu. It provides 
 * the methods and actions available to the object in the main menu.
 * @author Anton
 */
public class MainMenuController implements ScreenController{
    private Nifty nifty;
    private Screen screen;
    private List<String> displayedLevels;
    
    public MainMenuController(){

    }
   
    /**
     * This mehtod is run when the control is bound to the screen through the controll() method in MainMenu.
     * @param nifty
     * @param screen 
     */
    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    /**
     * This method is run everytime the screen is displayed.
     */
    @Override
    public void onStartScreen() {

    }

    /**
     * This method is run everytime the screen is no longer displayed.
     */
    @Override
    public void onEndScreen() {
        
    }
    
    /**
     * Start the game with the selected level.
     */
    public void startGame(){
        //Get the selected level.
        ImageSelect levelSelectBox = screen.findNiftyControl("levelSelectBox", ImageSelect.class);
        int selectedLevel = levelSelectBox.getSelectedImageIndex()+1; //+1 is used as the levelSelectBox start at 0 but the first level is 1
        
        //Get the gameAppState and set the level to start. Might need rework for pause and restart to work...
        StateManagerWrapper.getInstance().deactivateState(StateManagerWrapper.getInstance().getState(MainMenuAppState.class));
        GameAppState appState = (GameAppState)StateManagerWrapper.getInstance().getState(GameAppState.class);
        appState.setLevelToStart(selectedLevel);
        StateManagerWrapper.getInstance().activateState(appState);
        appState.startLevel();
        
        
    }
    /**
     * Method run by the Quit button, shuts down the game.
     */
    public void quitGame(){
        System.out.println("Shutting down...");
        Main.shutDown();
        
    }
    
    public void settings(){
        NiftyGUIWrapper.getInstance().goToScreen("settingsMenu");
    }
    
    public void profile(){
        NiftyGUIWrapper.getInstance().goToScreen("profileMenu");
    }
    
    
}
