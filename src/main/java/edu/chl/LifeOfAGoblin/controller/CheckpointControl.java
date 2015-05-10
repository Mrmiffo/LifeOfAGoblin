/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import edu.chl.LifeOfAGoblin.factory.NodeFactory;
import edu.chl.LifeOfAGoblin.factory.NodeType;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fredrik
 * A class that represents a node in the game that can update the 
 * progress class and that the player can respawn at.
 */
public class CheckpointControl extends Node implements INode, PhysicsCollisionListener {
    private int level;
    private int number;
    private boolean activated;
    private Vector3f halfExtent;
    
 /**
 *
 * Creates a CheckpointControl object.
 * @param level the level the CheckpointControl is associated with.
 * @param number the CheckpointControls position in relation to other 
 * CheckpointControls on the level.
 * @param halfExtent the size of the collisionbody from the center of the 
 * checkpointcontrol to its borders.
 */
    public CheckpointControl(int level, int number, Vector3f halfExtent){
        this.setUserData("objectType", "Checkpoint");
        this.level = level;
        this.number = number;
        this.activated = false;
        PhysicsWrapper.getInstance().getBulletAppState().getPhysicsSpace().addCollisionListener(this);
        BoxCollisionShape box = new BoxCollisionShape(halfExtent);
        GhostControl ghost = new GhostControl(box);
        this.getParent().addControl(ghost);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.CHECKPOINT;
    }
    /**
     * sets wheter or not this CheckpointControl has been activated
     * in this game.
     * @param isActivated true if the player has collided with this 
     * checkpointControl during this game.
     */
    public void setActivated(boolean isActivated){
        this.activated = isActivated;
    }
    
        @Override
    public Map<String, Object> getNodeData() {
        Map<String, Object> nodeData = new HashMap<>();
        nodeData.put("level", level);
        nodeData.put("number", number);
        nodeData.put("halfExtent", halfExtent);  
        nodeData.put("activated", activated); 
        return nodeData;
    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
          if (((INode)pce.getNodeA()).getNodeType().equals(NodeType.PLAYER) && !this.activated){
              this.setActivated(true);
              //todo notify progress
          }
    }
     
}
