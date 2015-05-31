/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.utils;

import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import java.util.ArrayList;

/**
 * This is a wrapper class intended to move state managment from LifeOfAGoblin class 
 * and make if available through out the application for switching states.
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
    
    /**
     * Method to initialize the stateManager. Must be called prior to any other 
     * calls. 
     * @param stateManager 
     */
    public void initialize(AppStateManager stateManager){
        sm = stateManager;
        states = new ArrayList();
    }
    
    /**
     * Add a state to the list of available states. NOTE: State will not become active.
     * @param as the state to add to the list of states.
     */
    public void addState(AppState as){
        states.add(as);
    }
    
    /**
     * Remove the state from the list of available states. NOTE: If the state is active it will be deactivated.
     * @param as the state to remove and detach.
     */
    public void removeState(AppState as){
        states.remove(as);
        sm.detach(as);
    }
    
    /**
     * Activates the state. Also adds the state to the list of available states 
     * if it does not exist there.
     * @param as the state to activate
     */
    public void activateState(AppState as){
        sm.attach(as);

        if (!states.contains(as)){
            states.add(as);
        }
    }

    
    /**
     * Deactivates the states. NOTE: State will still be available in the list of available states.
     * @param as the state to deactivate
     */
    public void deactivateState(AppState as){
        sm.detach(as);
    }
    
    /**
     * Enables the app state.
     * @param as the app state to enable
     */
    public void enableState(AppState as) {
        if (!as.isEnabled()) {
            as.setEnabled(true);
        }
    }
    
    /**
     * Disables the app state.
     * @param as the app state to disable
     */
    public void disableState(AppState as) {
        if (as.isEnabled()) {
            as.setEnabled(false);
        }
    }
    

    public ArrayList<AppState> getAvailableStates(){
        return (ArrayList<AppState>)states.clone();
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
