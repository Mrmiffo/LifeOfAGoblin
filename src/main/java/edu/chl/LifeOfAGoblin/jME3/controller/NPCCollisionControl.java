/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author Ulrika
 */
public class NPCCollisionControl extends AbstractControl {
    /**
     * 
     * @param collided the object with which the GhostControl has collided with
     */
    private void updateCollisionInfo(Spatial npc, Spatial collided) {
        INode n = npc.getControl(ModelControl.class).getModel();
        AbstractNPC npcModel = (AbstractNPC)n;
        
        Vector3f npcLocation = npc.getLocalTranslation();
        
        float distance = npcLocation.distance(collided.getLocalTranslation());
        
        float deltaX = npcLocation.getX() - collided.getLocalTranslation().getX();
        Direction direction; //TODO Replace with enum?
        if (deltaX >= 0) {
            direction = Direction.LEFT;
        } else {
            direction = Direction.RIGHT;
        }
        
        INode collideModel = collided.getControl(ModelControl.class).getModel();

        npcModel.updateAIAction(distance, direction, collideModel.getNodeType());
    }

    @Override
    protected void controlUpdate(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } //TODO Do things here instead?

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
