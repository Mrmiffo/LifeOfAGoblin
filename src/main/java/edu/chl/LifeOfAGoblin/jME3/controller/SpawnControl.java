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
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnControl;

/**
 * A control that belongs to a SpawnPoint. It is responsible for creating new
 * spawnables, attaching them to the level and moving them to the correct 
 * position.
 * @author fredrik
 */

public class SpawnControl extends AbstractControl implements ISpawnControl {
   
    @Override
    public void spawn(int amount, NodeType type) {
        if (amount > 0 && type.getSpawnable()) {
            for (int i = 0; i<amount; i++) {
                Node node = NodeFactory.createNode(type);
            node.setUserData("nodeType", type.toString());
            this.getSpatial().getParent().attachChild(node);
            node.setLocalTranslation(this.getSpatial().getLocalTranslation());
            node.getControl(CharacterControl.class).warp(this.getSpatial().getLocalTranslation());
            }
        }
   }

    @Override
    protected void controlUpdate(float f) {
        //probably not needed
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //probably not needed    
    }
}
