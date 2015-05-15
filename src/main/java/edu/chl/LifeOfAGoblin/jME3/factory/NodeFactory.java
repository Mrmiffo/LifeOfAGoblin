/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

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
        for(int i = 0; i<nodeList.size(); i++){
            System.out.println("node är " + nodeList.get(i).toString());
            System.out.println(nodeList.get(i).getUserDataKeys().toString());
            System.out.println("noden i childrens localtranslation är " + nodeList.get(i).getLocalTranslation());
            if(((Node)nodeList.get(i)).getUserDataKeys().size() > 0){
                String type = ((String)((Node)nodeList.get(i)).getUserData("nodeType"));
                switch(type){
                    case("SPAWNPOINT"):
                        CollisionObjectPainter.paintCollisionObject(NodeType.SPAWNPOINT, ((Node)nodeList.get(i)));
                        break;
                    case("CHECKPOINT"):
                        CollisionObjectPainter.paintCollisionObject(NodeType.CHECKPOINT, ((Node)nodeList.get(i)));
                        break;
                    case("FINALCHECKPOINT"):
                        CollisionObjectPainter.paintCollisionObject(NodeType.FINALCHECKPOINT, ((Node)nodeList.get(i)));
                        break;
                    case("GAMEOBJECT"):
                        CollisionObjectPainter.paintCollisionObject(NodeType.GAMEOBJECT, ((Node)nodeList.get(i)));
                    case("PLAYER"):  
                        //Adding the player character to the level
                        Node playerNode = NodeFactory.createNode(NodeType.PLAYER/*((Level)levelToCreate).getPlayer()*/);
                        ChaseCamera chaseCam = new ChaseCamera(cam);
                        chaseCam.setRotationSensitivity(0);
                        chaseCam.setDefaultHorizontalRotation(new Float(Math.PI/2));
                        chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
                        playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
                        ((Node)nodeList.get(i)).attachChild(playerNode);
                        
                        //System.out.println("noden i childrens localtranslation är " + nodeList.get(i).getLocalTranslation());
                        playerNode.getControl(CharacterControl.class).warp(nodeList.get(i).getWorldTranslation());
                       // System.out.println(playerNode.getLocalTranslation());
                        levelNode.setLocalTranslation(0f, -5f, 0f);
                        break;
                }
            }   

        //Adding collisionshape
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(levelNode);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        CollisionObjectListener listener = new CollisionObjectListener();
        PhysicsWrapper.getInstance().addCollisonListener(listener);
        levelNode.addControl(listener);
        levelNode.addControl(landscape);
        
    }
        return levelNode;
    }
}
