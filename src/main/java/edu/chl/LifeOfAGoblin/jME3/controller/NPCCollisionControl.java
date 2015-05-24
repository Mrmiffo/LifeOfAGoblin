/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import edu.chl.LifeOfAGoblin.model.Direction;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractCharacter;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import java.util.List;

/**
 *
 * @author Ulrika
 */
public class NPCCollisionControl extends AbstractControl {
    /**
     * 
     * @param collided the object with which the GhostControl has collided with
     */
    public void updateCollisionInfo(Spatial npc, Spatial collided) {
        if (npc != collided && collided.getControl(ModelControl.class).getModel() instanceof AbstractCharacter) {
        INode n = npc.getControl(ModelControl.class).getModel();
        AbstractNPC npcModel = (AbstractNPC)n;
        
        Vector3f npcLocation = npc.getControl(CharacterControl.class).getPhysicsLocation();
        
        float distance;
        float npcX = npcLocation.getX();
        float collidedX = collided.getControl(CharacterControl.class).getPhysicsLocation().getX();
        if (npcX > collidedX) {
            distance = collidedX - npcX;
        } else {
            distance = npcX - collidedX;
        }
        
        Direction direction;
        if (distance >= 0) {
            direction = Direction.LEFT;
        } else {
            direction = Direction.RIGHT;
        }
        
        INode collideModel = collided.getControl(ModelControl.class).getModel();

        npcModel.updateAIAction(FastMath.abs(distance), direction, collideModel.getNodeType());
        }
    }

    @Override
    protected void controlUpdate(float f) {
        List<PhysicsCollisionObject> overlapping = this.spatial.getControl(GhostControl.class).getOverlappingObjects();
        for (PhysicsCollisionObject pco : overlapping) {
            Object userObject = pco.getUserObject();
            if (userObject.getClass() == Node.class) {
                Node node = (Node)userObject;
                if (node.getControl(ModelControl.class) != null) {
                    updateCollisionInfo(this.spatial, node);
                }
            }
        }
    } 

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //Do nothing
    }
}
