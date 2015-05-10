/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;

/**
 * This is a wrapper class intended to move state managment from LifeOfAGoblin class.
 * @author Anton
 */
public class StateManagerWrapper {
    private static StateManagerWrapper instance;
    private AppStateManager sm;
    private StateManagerWrapper(){
        
    }
    
    public static synchronized StateManagerWrapper getInstance(){
        if (instance == null){
            instance = new StateManagerWrapper();
        }
        return instance;
    }
    
    public void initialize(AppStateManager stateManager){
        sm = stateManager;
    }
    
    public void addState(AppState as){
        sm.attach(as);
    }
    
    public void removeState(AppState as){
        sm.detach(as);
    }
    
}
