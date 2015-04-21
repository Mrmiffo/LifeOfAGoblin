/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public class PlayerMoveControl extends AbstractControl{

    public PlayerMoveControl(){
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        /* Optional: rendering manipulation (for advanced users) */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
