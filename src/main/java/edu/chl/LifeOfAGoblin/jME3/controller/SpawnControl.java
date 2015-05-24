/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.control.CharacterControl;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.model.NodeType;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.interfaces.IActivatable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public synchronized void spawn(int amount, NodeType type) {
        if (amount > 0 && type.getSpawnable()) {
        for (int i = 0; i<amount; i++) {
                Node node = NodeFactory.createNode(type);
                node.setUserData("nodeType", type.toString());
                this.getSpatial().getParent().attachChild(node);
             //   node.setLocalTranslation(this.getSpatial().getLocalTranslation());
                node.getControl(CharacterControl.class).warp(this.getSpatial().getLocalTranslation());                notifyAll();
            }
        }
   }
    public void initialize(){
        this.activatable = (IActivatable) this.getSpatial().getControl(ModelControl.class).getModel();
    }
    
    @Override
    protected synchronized void controlUpdate(float f) {
        if(this.activatable.isActivated()&&!hasSpawned){
            this.hasSpawned = true;
            this.activatable.inactivate();
            if(this.activatable instanceof SpawnPoint){
                NodeType type = ((SpawnPoint)this.activatable).getType();
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
