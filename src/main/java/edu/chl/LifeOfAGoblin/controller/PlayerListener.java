/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public class PlayerListener extends AbstractControl implements ActionListener{

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals("walkLeft")){
            spatial.getControl(BetterCharacterControl.class).setWalkDirection(new Vector3f(-1f, 0f, 0f));
        } else if (name.equals("walkRight")){
            spatial.getControl(BetterCharacterControl.class).setWalkDirection(new Vector3f(1f, 0f, 0f));
        } else if (name.equals("jump") && isPressed){
            spatial.getControl(BetterCharacterControl.class).jump();
        }
    }

    @Override
    protected void controlUpdate(float tpf) {
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
}
