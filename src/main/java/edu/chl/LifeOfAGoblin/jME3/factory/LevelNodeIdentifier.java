/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.model.Checkpoint;
import edu.chl.LifeOfAGoblin.model.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.Player;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.abstractClass.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.interfaces.INode;

/**
 *
 * @author kakan
 */
public class LevelNodeIdentifier {
    
    public static void indentifyNode(Node levelNode, Node node, Camera cam) {
        if(node.getUserDataKeys().size() > 0) {
            INode model = nodeToModel(node);
            
            if (model instanceof Player) {
                NodeFactory.createPlayer(levelNode, node, cam);
            }
            
            else if (model instanceof AbstractNPC) {
                NodeFactory.createNode((AbstractNPC) model);
            }
            
            CollisionObjectPainter.paintCollisionObject(model, node);
        }
    }

    private static INode nodeToModel(Node node) {
        
        String type = ((String)node.getUserData("nodeType"));
        
        if (type.equals("PLAYER")){
            return new Player();
        }
        
        float width = node.getUserData("WIDTH");
        
        if (type.equals("CHECKPOINT")) {
            int level = node.getUserData("LEVEL");
            int number = node.getUserData("NUMBER");
            return new Checkpoint(level, number, width);
            
        } else if (type.equals("FINALCHECKPOINT")) {
            int level = node.getUserData("LEVEL");
            int number = node.getUserData("NUMBER");
            return new FinalCheckpoint(level, number, width);
        
        } else if (type.equals("SPAWNPOINT")) {
            int amount = node.getUserData("AMOUNT");
            String spawnType = node.getUserData("TYPE");
            switch(spawnType) {
                case "PLAYER":
                    return new SpawnPoint(new SpawnControl(), amount, NodeType.PLAYER, width);
                case "BOSS":
                    return new SpawnPoint(new SpawnControl(), amount, NodeType.BOSS, width);
                case "MINION":
                    return new SpawnPoint(new SpawnControl(), amount, NodeType.MINION, width);
            }
            
        } else if (type.equals("GAMEOBJECT")) {
            //Not implemented yet
        
        }
        
        
        
        return null;
    }
}

                
                

//
//            case("PLAYER"):  
//                //Adding the player character to the level
//                Node playerNode = NodeFactory.createNode(NodeType.PLAYER/*((Level)levelToCreate).getPlayer()*/);
//                ChaseCamera chaseCam = new ChaseCamera(cam);
//                chaseCam.setRotationSensitivity(0);
//                chaseCam.setDefaultHorizontalRotation(new Float(Math.PI/2));
//                chaseCam.setDefaultVerticalRotation(new Float(FastMath.PI/9)); //20 degrees
//                playerNode.addControl(chaseCam); //Adding a camera control to make the camera follow the player
//                node.attachChild(playerNode);
//
//                playerNode.setLocalTranslation(node.getWorldTranslation());
//                levelNode.setLocalTranslation(0f, -5f, 0f);  
//                PhysicsTickControl ptc = new PhysicsTickControl(playerNode);
//                levelNode.addControl(ptc);
//                PhysicsWrapper.getInstance().add(((PhysicsTickListener)ptc));
//
//                break;
//        }        