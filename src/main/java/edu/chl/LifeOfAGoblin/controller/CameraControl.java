/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author kakan
 */
public class CameraControl extends AbstractControl {
    private boolean isFixed;
    private Spatial player = spatial.getPlayer();
    private Camera cam = spatial.getCamera();
    private Vector3f defaultDistanceToPlayer = new Vector3f(0, 3.8f, 10);
    
    @Override
    protected void controlUpdate(float tpf) {
        if (!isFixed) {
            Vector3f location = new Vector3f(player.getLocalTranslation());
            cam.setLocation(location.add(defaultDistanceToPlayer));
        }
    }
}
