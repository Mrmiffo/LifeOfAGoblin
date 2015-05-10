/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.factory;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.controller.PlayerMoveControl;
import edu.chl.LifeOfAGoblin.model.Level;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.interfaces.IModeledNode;
import edu.chl.LifeOfAGoblin.utils.InputManagerWrapper;
import edu.chl.LifeOfAGoblin.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.utils.Resources;
import java.util.Set;

/**
 *
 * @author Anton
 */
public class NodeFactory {

    
    public NodeFactory(){
        
    }
    
    public static Node createModeledNode(IModeledNode nodeToCreate){
        Node node = new Node();
        node.attachChild(Resources.getInstance().getResources(nodeToCreate.getModel()));
        //Setting object data:
        Set<String> tempSet = nodeToCreate.getNodeData().keySet();
        for (String key: tempSet){
            node.setUserData(key, nodeToCreate.getNodeData().get(key));
        }
        
        switch (nodeToCreate.getNodeType()){
            case PLAYER:
                float collisionShapeHeight = 1f;
                float collisionShapeWidth = 0.5f;
                //Moving the model node slightly to fit the CollisionShape
                node.getChild(0).setLocalTranslation(new Vector3f(0,-collisionShapeHeight,0));
                //Setting upp collision shape and character control:
                CapsuleCollisionShape shape = new CapsuleCollisionShape(collisionShapeWidth, collisionShapeHeight, 1);
                //CharacterControl has been depricated prematurly due to BetterCharacterControl. Although BetterCharacterControl contains major flaws (such as missing step height) that make CharacterControl a better choice for this project.
                CharacterControl mover = new CharacterControl(shape, 0.05f);
                PhysicsWrapper.getInstance().add(mover);
                //Set the character jumpspeed. 12 is just right for this character to jump 1f.
                mover.setJumpSpeed(12);
                //Setting up PlayerMoveControl which translates keycommands(key binds) to node actions.
                PlayerMoveControl pmc = new PlayerMoveControl();
                InputManagerWrapper.getInstance().registerListener(pmc);
                //Attaching controls:
                node.addControl(mover);
                node.addControl(pmc);
                break;
            case LEVEL:
                //Adding the player character to the level
                Player player = new Player(100, 100);
                node.attachChild(NodeFactory.createModeledNode(player));
                node.setLocalTranslation(0f, -5f, 0f);
                //Adding collisionshape
                CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(node);
                RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
                PhysicsWrapper.getInstance().add(landscape);
                node.addControl(landscape);
                
                //TODO REMOVE -> FOR TESTING PURPOSES ONLY
                //Adding a basic ambient light to the level
                AmbientLight l = new AmbientLight();
                l.setColor(ColorRGBA.White.mult(3f));
                node.addLight(l);
                break;
        }
            
        
        return node;
    }
    
    public static Node createModeledLevelNode(Level levelToCreate, Camera cam){
        Node node = new Node();
        node.attachChild(Resources.getInstance().getResources(levelToCreate.getModel()));
        //Setting object data:
        Set<String> tempSet = levelToCreate.getNodeData().keySet();
        for (String key: tempSet){
            node.setUserData(key, levelToCreate.getNodeData().get(key));
        }
        
        //Adding the player character to the level
        Player player = new Player(100, 100);
        Node playerNode = NodeFactory.createModeledNode(player);
        ChaseCamera chaseCam = new ChaseCamera(cam);
        chaseCam.setRotationSensitivity(0);
        chaseCam.setDefaultHorizontalRotation(new Float(Math.PI/2));
        playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
        node.attachChild(playerNode);
        node.setLocalTranslation(0f, -5f, 0f);
        
        //Adding collisionshape
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(node);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        PhysicsWrapper.getInstance().add(landscape);
        node.addControl(landscape);

        //TODO REMOVE -> FOR TESTING PURPOSES ONLY
        //Adding a basic ambient light to the level
        AmbientLight l = new AmbientLight();
        l.setColor(ColorRGBA.White.mult(3f));
        node.addLight(l);
        
        return node;
    }
}
