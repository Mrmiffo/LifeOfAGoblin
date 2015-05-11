/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author kakan
 */
public class AbstractMoveControl extends AbstractControl {
    
    protected boolean right;
    protected boolean left;
    protected CharacterControl playerControl;

    @Override
    protected void controlUpdate(float tpf) {
        if (right) {
            faceRight();
            playerControl.setWalkDirection(new Vector3f(0.1f, 0f, 0f));
        } else if (left) {
            faceLeft();
            playerControl.setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
        } else {
            haltPlayer();
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    private void faceLeft() {
        playerControl.setViewDirection(new Vector3f(-1, 0, 0));
    }
    
    private void faceRight() {
        playerControl.setViewDirection(new Vector3f(1, 0, 0));
    }
    
    private  void faceFront() {
        playerControl.setViewDirection(new Vector3f(0, 0, 1));
    }
    
    private void haltPlayer() {
        playerControl.setWalkDirection(Vector3f.ZERO);
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        if (spatial != null) {
            playerControl = spatial.getControl(CharacterControl.class);
        } else {
            playerControl = null;
        }
    }
    
}
