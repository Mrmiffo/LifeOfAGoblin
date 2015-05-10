/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.app.Application;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;

/**
 *
 * @author Anton
 */
public class NiftyGUIWrapper {
    private static NiftyGUIWrapper instance;
    private Nifty nifty;
    private NiftyGUIWrapper(){
        
    }
    
    public synchronized static NiftyGUIWrapper getInstance(){
        if (instance == null){
            instance = new NiftyGUIWrapper();
        }
        return instance;
    }
    
    public void initialize(Application app){
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(
                app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
        this.nifty = niftyDisplay.getNifty();
        app.getGuiViewPort().addProcessor(niftyDisplay);
    }
    
    public void setDebug(Boolean debugStatus){
        nifty.setDebugOptionPanelColors(debugStatus);
    }
    
    public void loadStyleFile(String file){
        nifty.loadStyleFile(file);
    }
    
    public void loadControlFile(String file){
        nifty.loadControlFile(file); 
    }
    
    public void goToScreen(String screenName){
        nifty.gotoScreen(screenName);
    }
    
    public void addScreen(String screenName, Screen screen){
        nifty.addScreen(screenName, screen);
    }
    
    public Nifty getNifty(){
        return nifty;
    }
}
