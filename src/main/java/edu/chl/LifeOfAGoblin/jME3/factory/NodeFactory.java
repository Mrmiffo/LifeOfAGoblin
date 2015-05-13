/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.Boss;
import edu.chl.LifeOfAGoblin.model.Minion;

/**
 * A factory used to create a level node and fill existing nodes with data depending on the node type.
 * The factory will extract needed data from the model and add jME3 controls and data.
 * @author Anton
 */
public class NodeFactory {
    
    public static Node createNode(NodeType nodetype){
        switch (nodetype) {
            case PLAYER:
                return CharacterFactory.createCharacter(new Player());
            case MINION:
                return CharacterFactory.createCharacter(new Minion());
            case BOSS:
                return CharacterFactory.createCharacter(new Boss());
//            case CHECKPOINT:
//                return CollisionObjectFactory.createCollisionObject(new Checkpoint());
//            case SPAWNPOINT:
//                return CollisionObjectFactory.createCollisionObject(new Spawnpoint());
//            case LEVEL:
//                return createModeledLevelNode(null, null);
            default:
            throw new InternalError("Error in NodeFactory: createNode()");
        }
    }
    
    public static Node createModeledLevelNode(Level levelToCreate, Camera cam){
        Node node = new Node();
        node.attachChild(Resources.getInstance().getResources(levelToCreate.getModelName()));
        node.addControl(new ModelControl(levelToCreate));
        
        //Adding the player character to the level
        Node playerNode = NodeFactory.createNode(NodeType.PLAYER/*((Level)levelToCreate).getPlayer()*/);
        
        ChaseCamera chaseCam = new ChaseCamera(cam);
        chaseCam.setRotationSensitivity(0);
        chaseCam.setDefaultHorizontalRotation(new Float(FastMath.HALF_PI));
        chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
        playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
        
        node.attachChild(playerNode);
        node.setLocalTranslation(0f, -5f, 0f);
        
        //Adding collisionshape
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(node);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        node.addControl(landscape);
        
        return node;
    }
    
    /**
     * Creates and returns a new Node based on a type and userData from another
     * node.
     * @param type The type of node to be created.
     * @param node The node containing the userData.
     * @return A new node of a specified NodeType with a model that matches the
     * parameter node's userData
     */
    public static Node createUserDataNode(NodeType type, Node node){
        switch (type) {
            case CHECKPOINT:
                return CollisionObjectFactory.createCollisionObject(type, node);
            case SPAWNPOINT:
               return CollisionObjectFactory.createCollisionObject(type, node);
        }
        return null;
    }
}
