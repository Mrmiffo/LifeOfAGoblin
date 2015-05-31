package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.INode;

/**
 * A control for a node which contains and provides the model object in the
 * node.
 *
 * @author Anton
 */
public class ModelControl extends AbstractControl {

    private INode model;

    /**
     * Creates an instance of ModelControl with a specified model.
     * @param model the model
     */
    public ModelControl(INode model) {
        this.model = model;
    }

    /**
     * Returns the model of the ModelControl.
     * @return the model
     */
    public INode getModel() {
        return model;
    }

    /**
     * Sets the model of the ModelControl.
     * @param newModel the model to be handled by the ModelControl
     */
    public void setModel(INode newModel) {
        model = newModel;
    }

    @Override
    protected void controlUpdate(float tpf) {
        //Do nothing
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //Do nothing
    }
}
