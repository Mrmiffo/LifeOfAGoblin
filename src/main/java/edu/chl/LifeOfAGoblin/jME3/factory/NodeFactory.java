/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.CollisionObjectListener;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.Boss;
import edu.chl.LifeOfAGoblin.model.Minion;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import java.util.List;

/**
 * A factory used to create a level node and fill existing nodes with data depending on the node type.
 * The factory will extract needed data from the model and add jME3 controls and data.
 * @author Anton
 */
public class NodeFactory {
    
    public static Node createNode(NodeType nodetype){
        switch (nodetype) {
            case PLAYER:
                throw new InternalError("Error in NodeFactory: createNode(). Player is not allowed.");
                //return CharacterFactory.createCharacter(new Player());
            case MINION:
                return CharacterFactory.createCharacter(new Minion());
            case BOSS:
                return CharacterFactory.createCharacter(new Boss());
            default:
            throw new InternalError("Error in NodeFactory: createNode()");
        }
    }
    
    public static Node createNode(AbstractNPC character) {
        return CharacterFactory.createCharacter(character);
    }
    
    public static void createPlayer(Node levelNode, Node node, Camera cam) {
        CharacterFactory.createPlayer(levelNode, node, cam);
    } 
    
    /**
     * Creates a Node represeting a level, gives it everything it needs based
     * on the provided levelObject's children and attaches camera, controls
     * and physics.
     * @param levelToCreate the Level object containing all the level's children
     * @param cam the camera to be attached to the level.
     * @return the finished levelNode.
     */
    public static Node createModeledLevelNode(Level levelToCreate, Camera cam){
        Node levelNode = ((Node)Resources.getInstance().getResources(levelToCreate.getModelName()));
        List<Spatial> nodeList = levelNode.getChildren();
        for(Spatial s: nodeList){
            LevelNodeIdentifier.identifyNode(levelNode, (Node)s, cam);
        }
        
        //Creating a CollisionShape that matches the terrain of the level.
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(levelNode);
        
        //Makes the shape solid.
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        levelNode.addControl(landscape);
        
        //----------------------------MOVE------------------------------
        //Allows object collision.
        CollisionObjectListener listener = new CollisionObjectListener();
        PhysicsWrapper.getInstance().addCollisionListener(listener);
        //--------------------------------------------------------------
        
        return levelNode;
    }
}
