/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.archive.controller.abstractClass.AbstractSetControl;

/**
 *
 * @author Anton
 */
public class PlayerSetControl extends AbstractSetControl{
    
    public PlayerSetControl(){
        
    }

    /** This method is called when the control is added to the spatial,
    * and when the control is removed from the spatial (setting a null value).
    * It can be used for both initialization and cleanup. */    
    @Override
    public void setSpatial(Spatial spatial) {
        //Each spatial has an objectType (in the AbstractGetControl), here we could check if the spatial is a valid type.
        super.setSpatial(spatial);
    }
    
    @Override
    protected void controlUpdate(float f) {
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    public void setHealth(int health){
        spatial.setUserData("health", health);
    }
    
    public void setMaxHealth(int maxHealth){
        spatial.setUserData("maxHealth", maxHealth);
    }
    
    
    
}
