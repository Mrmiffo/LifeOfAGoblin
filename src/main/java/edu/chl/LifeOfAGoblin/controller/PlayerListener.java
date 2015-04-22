/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Anton
 */
public class PlayerListener extends AbstractControl implements ActionListener{
    
     
     
     
    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
//        System.out.println(spatial.getWorldTranslation());
//        BetterCharacterControl test = spatial.getControl(BetterCharacterControl.class);
        
        if (name.equals("walkLeft")){
            spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(-0.1f, 0f, 0f));
        } 
        
        if (name.equals("walkRight")){
            spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(0.1f, 0f, 0f));
        }
        
        if (name.equals("jump") && isPressed){
            spatial.getControl(CharacterControl.class).jump();
        }
        
        if ((name.equals("walkLeft") || name.equals("walkRight")) && !isPressed){
            spatial.getControl(CharacterControl.class).setWalkDirection(new Vector3f(0f, 0f, 0f));
        }
    }

    @Override
    protected void controlUpdate(float tpf) {
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
    
}
