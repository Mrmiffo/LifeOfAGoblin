/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import edu.chl.LifeOfAGoblin.model.NodeType;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.model.gameObject.Checkpoint;
import edu.chl.LifeOfAGoblin.model.gameObject.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.gameObject.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import edu.chl.LifeOfAGoblin.model.INode;

/**
 *
 * @author kakan
 */
public class LevelNodeBuilder {
    
    public static void identifyNode(Node levelNode, Node node, Camera cam) {
        if(node.getUserDataKeys().size() > 0) {
            INode model = nodeToModel(node);
            if (model instanceof Player) {
                CharacterFactory.createPlayer(levelNode, node, cam);
            } else if (model instanceof AbstractNPC) {
                CharacterFactory.createCharacter((AbstractNPC) model);
            } else if (model instanceof ICollidable){
                CollisionObjectPainter.paintCollisionObject((ICollidable)model, node);
            }
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
