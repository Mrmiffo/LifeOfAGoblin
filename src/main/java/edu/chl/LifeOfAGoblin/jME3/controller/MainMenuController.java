/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ImageSelect;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.controls.ListBoxSelectionChangedEvent;
import de.lessvoid.nifty.controls.imageselect.builder.ImageSelectBuilder;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.main.Main;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.GameHud;
import java.util.ArrayList;
import java.util.List;

/**
 * The MainMenuController is the control class for the main menu. It provides 
 * the methods and actions available to the object in the main menu.
 * @author Anton
 */
public class MainMenuController implements ScreenController{
    private MainMenu mainMenu;
    private Nifty nifty;
    private Screen screen;
    private List<String> displayedLevels;
    
    public MainMenuController(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }
   

    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    @Override
    public void onStartScreen() {
        fillLevelSelectBox();
    }

    @Override
    public void onEndScreen() {
        
    }
    
    /**
     * Start the game with the selected level.
     */
    public void startGame(){
        //Get the selected level.
        ImageSelect levelSelectBox = screen.findNiftyControl("levelSelectBox", ImageSelect.class);
//        System.out.println("Level no:" +levelSelectBox.getSelectedImageIndex());
        GameHud hud = new GameHud();
        NiftyGUIWrapper.getInstance().addScreen(hud.getScreenName(), hud.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(hud.getScreenName());
        StateManagerWrapper.getInstance().addState(new GameAppState());
//        StateManagerWrapper.getInstance().addState(new GameAppState(selectedLevel));
        
    }
    /**
     * Method run by the Quit button, shuts down the game.
     */
    public void quitGame(){
        System.out.println("Shutting down...");
        Main.shutDown();
        
    }
    
    /**
     * Fills the list box with the names of the levels.
     */
    public void fillLevelSelectBox() {
//        Profile.getActiveProfile().getAvailableLevels();
        displayedLevels = new ArrayList<>();
//        displayedLevels.add(null);
        ImageSelect levelSelectBox = screen.findNiftyControl("levelSelectBox", ImageSelect.class);
//        levelSelectBox.addImage(); //Add a nifty image... Imagebuilder?
  }
    
    public void settings(){
        NiftyGUIWrapper.getInstance().goToScreen("settingsMenu");
    }
    
    
}
