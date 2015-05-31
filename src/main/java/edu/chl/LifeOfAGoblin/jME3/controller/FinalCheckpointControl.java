/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.game.GameAppState;
import edu.chl.LifeOfAGoblin.jME3.game.MainMenuAppState;
import edu.chl.LifeOfAGoblin.model.gameObject.IActivatable;
import edu.chl.LifeOfAGoblin.utils.StateManagerWrapper;

/**
 *
 * @author fredrik
 */
public class FinalCheckpointControl extends AbstractControl {

    private IActivatable activatable;
    private boolean gameEnded;

    public void initialize() {
        this.activatable = (IActivatable) this.getSpatial().getControl(ModelControl.class).getModel();
    }

    @Override
    protected void controlUpdate(float f) {
        if (this.activatable.isActivated() && !gameEnded && isEnabled()) {
            StateManagerWrapper.getInstance().detachState(StateManagerWrapper.getInstance().getAvailableState(GameAppState.class));
            StateManagerWrapper.getInstance().attachState(StateManagerWrapper.getInstance().getAvailableState(MainMenuAppState.class));
            System.out.println("End game NAWO!!!!!" + spatial.getLocalTranslation());
            gameEnded = true;
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
