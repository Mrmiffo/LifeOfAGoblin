/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import edu.chl.LifeOfAGoblin.jME3.view.niftyScreen.controller.GameHudController;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Player;

/**
 *
 * @author Anton
 */
public class PlayerHealthControl extends AbstractControl {
    
    private int lastHealth = 0;
    private int lastMaxHealth = 0;
    
    @Override
    protected void controlUpdate(float tpf) {
        Player player = (Player) spatial.getControl(ModelControl.class).getModel();
        if (player.getHealth() != lastHealth || player.getMaxHealth() != lastMaxHealth) {
            GameHudController.updateHudHealthbar(player.getHealth(), player.getMaxHealth());
            GameHudController.flashOnDamage(player.getHealth(), lastHealth);
            lastHealth = player.getHealth();
            lastMaxHealth = player.getMaxHealth();
        }
        if (player.isDead()) {
            for (int i = 0; i < spatial.getParent().getParent().getChildren().size(); i++) {
                if (spatial.getParent().getParent().getChildren().get(i).getUserDataKeys().contains("nodeType")) {
                    if (spatial.getParent().getParent().getChildren().get(i).getUserData("nodeType").equals("CHECKPOINT")) {
                  //  && spatial.getParent().getParent().getChildren().get(i).getUserData("NUMBER").equals(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint())){
                        spatial.getControl(CharacterControl.class).warp(spatial.getParent().getParent().getChildren().get(i).getLocalTranslation());
                        player.setHealth(player.getMaxHealth());
                        player.setIsDead(false);
                    }
                }
            }
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
}
