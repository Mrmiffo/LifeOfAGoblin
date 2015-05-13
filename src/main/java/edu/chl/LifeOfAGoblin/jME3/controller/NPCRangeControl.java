/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author Ulrika
 */
public class NPCRangeControl extends GhostControl implements PhysicsCollisionListener {

    public NPCRangeControl() {
        super(new SphereCollisionShape(3));
        PhysicsWrapper.getInstance().addCollisonListener(this);
        
        
    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
        
        if (pce.getNodeA() == this.spatial) {
            updateCollisionInfo(pce.getNodeB());
        } else if (pce.getNodeB() == this.spatial) {
            updateCollisionInfo(pce.getNodeA());
        }
    }
    
    /**
     * 
     * @param collided the object with which the GhostControl has collided with
     */
    private void updateCollisionInfo(Spatial collided) {
        INode n = this.spatial.getControl(ModelControl.class).getModel();
        AbstractNPC npcModel = (AbstractNPC)n;
        
        Vector3f npcLocation = this.spatial.getLocalTranslation();
        
        float distance = npcLocation.distance(collided.getLocalTranslation());
        
        float deltaX = npcLocation.getX() - collided.getLocalTranslation().getX();
        String direction; //TODO Replace with enum?
        if (deltaX >= 0) {
            direction = "left";
        } else {
            direction = "right";
        }
        
        INode collideModel = collided.getControl(ModelControl.class).getModel();

        npcModel.updateAIAction(distance, direction, collideModel.getNodeType());
    }
}
