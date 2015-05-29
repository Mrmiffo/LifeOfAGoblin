/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.model.ISpawnable;
import edu.chl.LifeOfAGoblin.model.gameObject.IActivatable;
import edu.chl.LifeOfAGoblin.model.gameObject.SpawnPoint;

/**
 * A control that belongs to a SpawnPoint. It is responsible for creating new
 * spawnables, attaching them to the level and moving them to the correct 
 * position.
 * @author fredrik
 */

public class SpawnControl extends AbstractControl{
   private IActivatable activatable;
   private boolean hasSpawned = false;
    /**
     * creates a number of spawnables and puts them in the game
     * @param amount the number of spawnables to put in the game
     * @param type the type of spawnable to put in the game
     */
    public void spawn(int amount, ISpawnable type) {
        if (amount > 0) {
            for (int i = 0; i<amount; i++) {
                Node spawn = NodeFactory.createNode(type);
                spawn.getControl(CharacterControl.class).warp(this.getSpatial().getLocalTranslation());
                ((Node)spatial).attachChild(spawn);
            }
        }
    }
    public void initialize(){
        this.activatable = (IActivatable) this.getSpatial().getControl(ModelControl.class).getModel();
    }
    
    @Override
    protected void controlUpdate(float f) {
        if(!this.activatable.isActivated()&&!hasSpawned){
            this.hasSpawned = true;
            this.activatable.activate();
            if(this.activatable instanceof SpawnPoint){
                ISpawnable type = ((SpawnPoint)this.activatable).getType();
                int amount = ((SpawnPoint)this.activatable).getAmount();  
                spawn(amount, type);
            }
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //probably not needed    
    }
}
