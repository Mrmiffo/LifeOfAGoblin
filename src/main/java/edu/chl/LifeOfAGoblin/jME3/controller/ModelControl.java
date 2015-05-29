/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.INode;

/**
 * A control for a node which contains and provides the model object in the node.
 * @author Anton
 */
public class ModelControl extends AbstractControl{
    private INode model;
    public ModelControl(INode model){
        this.model = model;
    }
    
    public INode getModel(){
        return model;
    }
    
    public void setModel(INode newModel){
        model = newModel;
    }

    @Override
    protected void controlUpdate(float tpf) {
       
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }
}
