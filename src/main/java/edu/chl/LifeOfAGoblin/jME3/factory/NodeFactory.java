/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.CollisionObjectListener;
import edu.chl.LifeOfAGoblin.jME3.controller.PhysicsTickControl;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import edu.chl.LifeOfAGoblin.model.Boss;
import edu.chl.LifeOfAGoblin.model.Minion;
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
                return CharacterFactory.createCharacter(new Player());
            case MINION:
                return CharacterFactory.createCharacter(new Minion());
            case BOSS:
                return CharacterFactory.createCharacter(new Boss());
            default:
            throw new InternalError("Error in NodeFactory: createNode()");
        }
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
            LevelNodeIdentifier.indentifyNode(levelNode, (Node)s, cam);
        }
        
        //Adding collisionshape
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(levelNode);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        CollisionObjectListener listener = new CollisionObjectListener();
        PhysicsWrapper.getInstance().addCollisonListener(listener);
        levelNode.addControl(listener);
        levelNode.addControl(landscape);
        return levelNode;
    }
}
