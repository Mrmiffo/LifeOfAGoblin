/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.archive.controller.abstractClass;

import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public abstract class AbstractGetControl extends AbstractControl {
    
    /** This method is called when the control is added to the spatial,
    * and when the control is removed from the spatial (setting a null value).
    * It can be used for both initialization and cleanup. */    
    @Override
    public void setSpatial(Spatial spatial) {
        //Each spatial has an objectType (in the AbstractGetControl), here we could check if the spatial is a valid type.
        super.setSpatial(spatial);
    }
    
    public String getObjectType(){
        return spatial.getUserData("objectType");
    }
}
