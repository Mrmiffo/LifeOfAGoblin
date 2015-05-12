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
    private CharacterControl characterControl;

    @Override
    protected void controlUpdate(float tpf) {
        if (characterControl.getPhysicsLocation().z != 0) {
            Vector3f currentLocation = characterControl.getPhysicsLocation();
            characterControl.warp(new Vector3f(currentLocation.x, currentLocation.y, currentLocation.z));
        }
        
        if (right) {
            faceRight();
            characterControl.setWalkDirection(new Vector3f(0.1f, 0f, 0f));
        } else if (left) {
            faceLeft();
            characterControl.setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
        } else {
            haltCharacter();
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
    protected void faceLeft() {
        characterControl.setViewDirection(new Vector3f(-1, 0, 0));
    }
    
    protected void faceRight() {
        characterControl.setViewDirection(new Vector3f(1, 0, 0));
    }
    
    protected  void faceFront() {
        characterControl.setViewDirection(new Vector3f(0, 0, 1));
    }
    
    protected void haltCharacter() {
        characterControl.setWalkDirection(Vector3f.ZERO);
    }
    
    protected void jump() {
        characterControl.jump();
    }
    
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
        if (spatial != null) {
            characterControl = spatial.getControl(CharacterControl.class);
        } else {
            characterControl = null;
        }
    }
    
}
