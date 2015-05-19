/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller.GameHudController;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Player;

/**
 *
 * @author Anton
 */
public class PlayerHealthControl extends AbstractControl{
    private int lastHealth = 0;
    private int lastMaxHealth = 0;
    @Override
    protected void controlUpdate(float tpf) {
        Player player = (Player) spatial.getControl(ModelControl.class).getModel();
        if (player.getHealth() != lastHealth || player.getMaxHealth() != lastMaxHealth){
            GameHudController.updateHudHealthbar(player.getHealth(), player.getMaxHealth());
            lastHealth = player.getHealth();
            lastMaxHealth = player.getMaxHealth();
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
}
