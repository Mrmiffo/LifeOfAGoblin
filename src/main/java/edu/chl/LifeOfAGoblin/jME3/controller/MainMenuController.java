/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import edu.chl.LifeOfAGoblin.jME3.view.state.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.view.state.MainMenuAppState;
import edu.chl.LifeOfAGoblin.jME3.utils.StateManagerWrapper;

/**
 *
 * @author Anton
 */
public class MainMenuController extends AbstractAppState implements ScreenController{
    private MainMenuAppState mainMenu;
    private Application app;
    
    public MainMenuController(MainMenuAppState mainMenu){
        this.mainMenu = mainMenu;
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        this.app = app;
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
        StateManagerWrapper.getInstance().removeState(mainMenu);
        StateManagerWrapper.getInstance().addState(new GameAppState());
        
    }
    
    public void quitGame(){
        System.out.println("Shutting down...");
        app.stop();
        
    }
    
}
