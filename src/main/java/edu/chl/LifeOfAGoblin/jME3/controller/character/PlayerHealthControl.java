package edu.chl.LifeOfAGoblin.jME3.controller.character;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import edu.chl.LifeOfAGoblin.jME3.controller.nifty.GameHudController;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.profile.Profile;
import edu.chl.LifeOfAGoblin.model.profile.Progress;
import java.util.List;

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
            Node scene = spatial.getParent();
            List<Spatial> children = scene.getChildren();
            
            for (Spatial child: children) {
                if (child.getUserDataKeys().contains("nodeType")) {
                    if (child.getUserData("nodeType").equals("CHECKPOINT")) {
                        int nbr = child.getUserData("NUMBER");
                        if (nbr == Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()) {
                        
                            //  && spatial.getParent().getParent().getChildren().get(i).getUserData("NUMBER").equals(Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint())){
                            spatial.getControl(CharacterControl.class).warp(child.getLocalTranslation().add(new Vector3f(0, 10, 0)));
                            player.setHealth(player.getMaxHealth());
                            player.setIsDead(false);
                        }
                    }
                }
            }
            
            
            
            Profile activeProfile = Profile.getActiveProfile();
            Progress progress = activeProfile.getProgress();
            progress.getLastVisitedCheckpoint();
            
            
            
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
}
