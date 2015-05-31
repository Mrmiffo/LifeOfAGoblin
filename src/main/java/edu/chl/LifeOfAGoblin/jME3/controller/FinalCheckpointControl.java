package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.game.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.game.MainMenuAppState;
import edu.chl.LifeOfAGoblin.model.gameObject.IActivatable;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;

/**
 * A control meant for attaching to IActivatables. Ends the level that is currently running
 * and displays the main menu, if the right conditions are met.
 * @author Ulrika Uddeborg
 */
public class FinalCheckpointControl extends AbstractControl {

    private IActivatable activatable;
    private boolean gameEnded;

    /**
     * Initializes the control.
     */
    public void initialize() {
        this.activatable = (IActivatable) this.getSpatial().getControl(ModelControl.class).getModel();
    }

    /**
     * Removes the game view and shows the main menu, if the game has not already ended.
     * @param tpf a float representing ticks per frame
     */
    @Override
    protected void controlUpdate(float tpf) {
        if (this.activatable.isActivated() && !gameEnded && isEnabled()) {
            detachGame();
            attachMainMenu();
            gameEnded = true;
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }

    /**
     * Detaches the GameAppState.
     */
    private void detachGame() {
        StateManagerWrapper.getInstance().detachState(StateManagerWrapper.getInstance().getAvailableState(GameAppState.class));
    }

    /**
     * Attaches the MainMenuAppState.
     */
    private void attachMainMenu() {
        StateManagerWrapper.getInstance().attachState(StateManagerWrapper.getInstance().getAvailableState(MainMenuAppState.class));
    }
}
