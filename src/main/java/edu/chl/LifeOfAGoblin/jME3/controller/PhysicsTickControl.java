/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Player;

/**
 *
 * @author fredrik
 */
public class PhysicsTickControl extends AbstractControl implements PhysicsTickListener {
    private Node player;
    private float loop = 1;
    public PhysicsTickControl(Node player){
        this.player = player;
    }

    @Override
    public void prePhysicsTick(PhysicsSpace ps, float f) {
    }

    @Override
    public void physicsTick(PhysicsSpace ps, float f) {
        this.loop-=1*f;
        if(this.loop<0){
           ((Player)player.getControl(ModelControl.class).getModel()).setIsDamaged(false);
           this.loop = 1;
        }
    }

    @Override
    protected void controlUpdate(float f) {
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
    
}