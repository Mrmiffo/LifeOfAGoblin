/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.app.Application;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.utils.NiftyGUIWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.MainMenu;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.GameHud;

/**
 *
 * @author Anton
 */
public class MainMenuController implements ScreenController{
    private MainMenu mainMenu;
    private Application app;
    
    public MainMenuController(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }
   

    @Override
    public void bind(Nifty nifty, Screen screen) {
        
    }

    @Override
    public void onStartScreen() {
        
    }

    @Override
    public void onEndScreen() {
        
    }
    
    public void startGame(){
        GameHud hud = new GameHud();
        NiftyGUIWrapper.getInstance().addScreen(hud.getScreenName(), hud.getScreen());
        NiftyGUIWrapper.getInstance().goToScreen(hud.getScreenName());
        StateManagerWrapper.getInstance().addState(new GameAppState());
        
    }
    
    public void quitGame(){
        System.out.println("Shutting down...");
        app.stop();
        
    }
    
}
