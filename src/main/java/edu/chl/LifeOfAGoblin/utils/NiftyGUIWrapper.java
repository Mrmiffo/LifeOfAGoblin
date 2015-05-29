/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.app.Application;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;

/**
 * A wrapper class for the Nifty instance for the NiftyGUI screens. Used to create
 * a single input channel for all registrations and transfers between nifty screens.
 * @author Anton
 */
public class NiftyGUIWrapper {
    private static NiftyGUIWrapper instance;
    private Nifty nifty;
    private NiftyGUIWrapper(){
        
    }
    /**
     * Basic getInstance method for singleton.
     * @return the singleton instance
     */
    public synchronized static NiftyGUIWrapper getInstance(){
        if (instance == null){
            instance = new NiftyGUIWrapper();
        }
        return instance;
    }
    
    /**
     * Initialize the nifty gui wrapper, setting upp the necessary controls and access to the application.
     * @param app The simple applications of the game.
     */
    public void initialize(Application app){
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(
                app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
        this.nifty = niftyDisplay.getNifty();
        app.getGuiViewPort().addProcessor(niftyDisplay);
    }
    /**
     * Only used when testing. Will make screens into random colors to see where they are.
     * @param debugStatus 
     */
    public void setDebug(Boolean debugStatus){
        nifty.setDebugOptionPanelColors(debugStatus);
    }
    
    /**
     * Loads a style
     * @param file 
     */
    public void loadStyleFile(String file){
        nifty.loadStyleFile(file);
    }
    
    /**
     * Loads a control file for nifty.
     * @param file 
     */
    public void loadControlFile(String file){
        nifty.loadControlFile(file); 
    }
    
    /**
     * Select which screen to go to. Screens needs to be added to nifty wrapper 
     * before they this method is called.
     * @param screenName The name of the screen to display
     */
    public void goToScreen(String screenName){
        nifty.gotoScreen(screenName);
    }
    
    /**
     * Adds a screen to the list of available screen. Once added use GoToScreen 
     * to display the screen. 
     * @param screenName The name of the screen. Used in goToScreen
     * @param screen the screen to be added
     */
    public void addScreen(String screenName, Screen screen){
        nifty.addScreen(screenName, screen);
    }
    
    /**
     * returns the nifty instance. Needed when building the nifty screens.
     * @return the nifty instance.
     */
    public Nifty getNifty(){
        return nifty;
    }
}
