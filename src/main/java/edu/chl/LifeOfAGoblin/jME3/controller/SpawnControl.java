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
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.model.interfaces.ISpawnControl;

/**
 * A control that belongs to a SpawnPoint. It is responsible for creating new
 * spawnables and attaching them to the level.
 * @author fredrik
 */
public class SpawnControl extends AbstractControl implements ISpawnControl{
   @Override
   public void Spawn(int amount, NodeType type){
    Node node = NodeFactory.createNode(type);
    this.getSpatial().getParent().attachChild(node);
    System.out.println(this.getSpatial().getParent().toString());
    System.out.println(this.getSpatial().getLocalTranslation());
    node.setLocalTranslation(this.getSpatial().getLocalTranslation());
    node.getControl(CharacterControl.class).warp(this.getSpatial().getLocalTranslation());


   }

    @Override
    protected void controlUpdate(float f) {
        //probably not needed, active mvc ftw
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
     //probably not needed    
    }
}
