package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import edu.chl.LifeOfAGoblin.jME3.controller.nifty.GameHudController;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.character.Player;

/**
 * A control for updating the game hud. Also checks if player is dead, if so respawn the character.
 * @author Anton & Fredrik
 */
public class PlayerHealthControl extends AbstractControl {
    
    private int lastHealth = 0;
    private int lastMaxHealth = 0;
    
    @Override
    protected void controlUpdate(float tpf) {
        Player player = (Player) spatial.getControl(ModelControl.class).getModel();
        //Checks if the health is the same as the last time the update method was run, if unchanged do nothing, if changed set the new health as last health and update hud.
        if (player.getHealth() != lastHealth || player.getMaxHealth() != lastMaxHealth) {
            GameHudController.updateHudHealthbar(player.getHealth(), player.getMaxHealth());
            //Checks if the player took damage, if so flash the screen.
            if (player.getHealth() < lastHealth){
                GameHudController.flashOnDamage();
            }
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
