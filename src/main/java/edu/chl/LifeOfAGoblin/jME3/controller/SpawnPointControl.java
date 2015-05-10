/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.controller;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;
import edu.chl.LifeOfAGoblin.jME3.factory.NodeType;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;

/**
 *
 * @author Fredrik
 * A class that represents a node in the game that can notify the
 * level?? to spawn a certain type of minion.
 * 
 */
public class SpawnPointControl extends Node implements INode, PhysicsCollisionListener {
    private NodeType minion;
    private Vector3f halfExtent;
    
    /**
     * Creates a SpawnPointControl object,
     * @param halfExtent the size of the collisionbody from the center of the 
     * SpawnPointControl to its borders.
     * @param minion  the type of minion associated with this 
     * SpawnPointControl
     */
    public SpawnPointControl(Vector3f halfExtent, NodeType minion ){
        this.setUserData("objectType", "Checkpoint");
        this.minion = minion;
        PhysicsWrapper.getInstance().getBulletAppState().getPhysicsSpace().addCollisionListener(this);
        BoxCollisionShape box = new BoxCollisionShape(halfExtent);
        GhostControl ghost = new GhostControl(box);
        this.getParent().addControl(ghost);
    }
    
    @Override
    public NodeType getNodeType() {
        return NodeType.SPAWNPOINT;
    }
    
    
//        @Override
//    public Map<String, Object> getNodeData() {
//        Map<String, Object> nodeData = new HashMap<>();
//        nodeData.put("halfExtent", halfExtent); 
//        nodeData.put("minion", minion); 
//        return nodeData;
//    }

    @Override
    public void collision(PhysicsCollisionEvent pce) {
        if (((INode)pce.getNodeA()).getNodeType().equals(NodeType.PLAYER)){
        //Todo notify level
        }   
          
    }
     
}
