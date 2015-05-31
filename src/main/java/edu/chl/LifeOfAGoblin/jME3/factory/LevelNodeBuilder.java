/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.model.gameObject.Checkpoint;
import edu.chl.LifeOfAGoblin.model.character.Player;
import edu.chl.LifeOfAGoblin.model.gameObject.SpawnPoint;
import edu.chl.LifeOfAGoblin.model.character.AbstractNPC;
import edu.chl.LifeOfAGoblin.model.ICollidable;
import edu.chl.LifeOfAGoblin.model.INode;
import edu.chl.LifeOfAGoblin.model.character.Boss;
import edu.chl.LifeOfAGoblin.model.character.Minion;

/**
 * The LevelNodeBuilder will paint the nodes in a level into objects.
 *
 * @author kakan
 */
public class LevelNodeBuilder {

    /**
     * A package protected method used to pain the nodes contianed in the level
     * node into game objects.
     *
     * @param node The level node which contains nodes to paint.
     * @param cam The camera of the game, will be set to follow the player.
     */
    static void paintNode(Node node, Camera cam) {
        if (node.getUserDataKeys().size() > 0) {
            INode model = nodeToModel(node);
            if (model instanceof Player) {
                CharacterPainter.paintCharacter(node, (Player) model);

                ChaseCamera chaseCam = new ChaseCamera(cam);
                chaseCam.setRotationSensitivity(0);
                chaseCam.setDefaultHorizontalRotation(FastMath.PI / 2);
                chaseCam.setDefaultVerticalRotation(FastMath.PI / 9); //20 degrees
                node.addControl(chaseCam);
            } else if (model instanceof AbstractNPC) {
                CharacterPainter.paintCharacter(node, (AbstractNPC) model);
            } else if (model instanceof ICollidable) {
                CollisionObjectPainter.paintCollisionObject((ICollidable) model, node);
            }
        }
    }

    private static INode nodeToModel(Node node) {
        String type = ((String) node.getUserData("nodeType"));
        if (type.equals("PLAYER")) {
            return new Player();
        }

        float width = node.getUserData("WIDTH");
        
        if (type.equals("CHECKPOINT") || type.equals("FINALCHECKPOINT")) {
            int level = node.getUserData("LEVEL");
            int number = node.getUserData("NUMBER");
            return new Checkpoint(level, number, width);
        } else if (type.equals("SPAWNPOINT")) {
            int amount = node.getUserData("AMOUNT");
            String spawnType = node.getUserData("TYPE");
            switch (spawnType) {
                case "BOSS":
                    return new SpawnPoint(amount, Boss.class, width);
                case "MINION":
                    return new SpawnPoint(amount, Minion.class, width);
            }

        }
        return null;
    }
}
