/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import edu.chl.LifeOfAGoblin.jME3.controller.CollisionObjectListener;
import edu.chl.LifeOfAGoblin.jME3.controller.PhysicsTickControl;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.jME3.utils.Resources;
import java.util.List;

/**
 *
 * @author kakan
 */
public class LevelNodeIdentifier {
    
    public static void indentifyNode(Node levelNode, Node node, Camera cam) {
        if(node.getUserDataKeys().size() > 0) {
            String type = ((String)node.getUserData("nodeType"));
            switch(type){
                case("SPAWNPOINT"):
                    CollisionObjectPainter.paintCollisionObject(NodeType.SPAWNPOINT, node);
                    break;
                    
                case("CHECKPOINT"):
                    CollisionObjectPainter.paintCollisionObject(NodeType.CHECKPOINT, node);
                    node.setLocalTranslation(0, 2, 0);
                    break;
                    
                case("FINALCHECKPOINT"):
                    CollisionObjectPainter.paintCollisionObject(NodeType.FINALCHECKPOINT, node);
                    break;
                    
                case("GAMEOBJECT"):
                    CollisionObjectPainter.paintCollisionObject(NodeType.GAMEOBJECT, node);
                    break;
                    
                case("PLAYER"):  
                    //Adding the player character to the level
                    Node playerNode = NodeFactory.createNode(NodeType.PLAYER/*((Level)levelToCreate).getPlayer()*/);
                    ChaseCamera chaseCam = new ChaseCamera(cam);
                    chaseCam.setRotationSensitivity(0);
                    chaseCam.setDefaultHorizontalRotation(new Float(Math.PI/2));
                    chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
                    playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
                    node.attachChild(playerNode);

                    playerNode.setLocalTranslation(node.getWorldTranslation());
                    levelNode.setLocalTranslation(0f, -5f, 0f);  
                    PhysicsTickControl ptc = new PhysicsTickControl(playerNode);
                    levelNode.addControl(ptc);
                    PhysicsWrapper.getInstance().add(((PhysicsTickListener)ptc));

                    break;
            }
        }
    }
}
