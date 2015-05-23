/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.utils;

import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import edu.chl.LifeOfAGoblin.jME3.view.state.PauseAppState;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a wrapper class intended to move state managment from LifeOfAGoblin class.
 * @author Anton
 */
public class StateManagerWrapper {
    private static StateManagerWrapper instance;
    private AppStateManager sm;
    private ArrayList<AppState> states;
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
        states = new ArrayList();
    }
    
    public void addState(AppState as){
        states.add(as);
    }
    
    public void removeState(AppState as){
        states.remove(as);
    }
    
    public void activateState(AppState as){
        sm.attach(as);
        states.add(as);
    }
    
    public void deactivateState(AppState as){
        sm.detach(as);
    }
    
    public ArrayList<AppState> getStates(){
        return states;
    }
    
    public AppState getAvailableState(Class<? extends AppState> appStateType){
        AppState toReturn = null;
        for (AppState state: states){
            if (state.getClass() == appStateType){
                toReturn = state;
                break;
            }
        }
        return toReturn;
    }
    
    public AppState getActiveState(Class<? extends AppState> appStateType){
        return sm.getState(appStateType);
    }
   
}
