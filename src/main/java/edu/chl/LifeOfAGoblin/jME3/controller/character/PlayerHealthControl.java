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

/**
 * A control for updating the game hud. Also checks if player is dead, if so
 * respawn the character.
 *
 * @author Anton & Fredrik
 */
public class PlayerHealthControl extends AbstractControl {

    private int lastHealth = 0;
    private int lastMaxHealth = 0;

    @Override
    protected void controlUpdate(float tpf) {
        Player player = (Player)spatial.getControl(ModelControl.class).getModel();
        
        /* Checks if the health is the same as the last time the update method was run,
         * if unchanged do nothing, if changed set the new health as last health and update hud. */
        if (player.getHealth() != lastHealth || player.getMaxHealth() != lastMaxHealth) {
            GameHudController.updateHudHealthbar(player.getHealth(), player.getMaxHealth());
            
            //Checks if the player took damage, if so flash the screen.
            if (player.getHealth() < lastHealth) {
                GameHudController.flashOnDamage();
            }
            
            lastHealth = player.getHealth();
            lastMaxHealth = player.getMaxHealth();
        }
        
        if (player.isDead()) {
            Node scene = spatial.getParent();

            //Loop through all the pre-placed nodes in the current scene
            for (Spatial child : scene.getChildren()) {
                if (child.getUserDataKeys().contains("nodeType")) {
                    //Search for all checkpoints
                    if (child.getUserData("nodeType").equals("CHECKPOINT")) {
                        //All checkpoints contain a number (index)
                        int nbr = child.getUserData("NUMBER");
                        
                        //Check whether the number corresponds to the active profile's current progress.
                        if (nbr == Profile.getActiveProfile().getProgress().getLastVisitedCheckpoint()) {
                            //The the number corresponds, place the player slightly above the location of the checkpoint.
                            spatial.getControl(CharacterControl.class).warp(child.getLocalTranslation().add(new Vector3f(0, 5, 0)));
                            //Restore the player's health.
                            player.setHealth(player.getMaxHealth());
                            //The player is no longer dead.
                            player.setIsDead(false);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
