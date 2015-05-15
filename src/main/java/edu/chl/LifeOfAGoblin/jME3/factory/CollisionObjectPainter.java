/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.jME3.utils.PhysicsWrapper;
import edu.chl.LifeOfAGoblin.model.Checkpoint;
import edu.chl.LifeOfAGoblin.model.FinalCheckpoint;
import edu.chl.LifeOfAGoblin.model.SpawnPoint;

/**
 * A class responsible for "painting" nodes giving them models and adding
 * controls
 * @author fredrik
 */

class CollisionObjectPainter {
    /**
     * Paints a node of the type collisionObject
     * @param typeToCreate the specific type of collisionobject to create
     * @param userDataNode the node to be painted. It also contains all 
     * relevant userdata.
     */
    
    static void paintCollisionObject(NodeType typeToCreate, Node userDataNode) {
        float width = userDataNode.getUserData("WIDTH");
        switch (typeToCreate) {
            case CHECKPOINT:
                int level = userDataNode.getUserData("LEVEL");
                int number = userDataNode.getUserData("NUMBER");
                Checkpoint cp = new Checkpoint(level, number, width);
                ModelControl checkMc = new ModelControl(cp);
                Vector3f checkhalfExtent = new Vector3f(cp.getWidth(),cp.getHeight(), 0);
                BoxCollisionShape checkBox = new BoxCollisionShape(checkhalfExtent);
                GhostControl checkGhost = new GhostControl(checkBox);
                checkGhost.setCollisionGroup(3);
                checkGhost.setCollideWithGroups(2);
                PhysicsWrapper.getInstance().add(checkGhost);
                userDataNode.addControl(checkMc);
                userDataNode.addControl(checkGhost);
                break;
                case FINALCHECKPOINT:
                int flevel = userDataNode.getUserData("LEVEL");
                int fnumber = userDataNode.getUserData("NUMBER");
                FinalCheckpoint fcp = new FinalCheckpoint(flevel, fnumber, width);
                ModelControl fCheckMc = new ModelControl(fcp);
                Vector3f fcheckhalfExtent = new Vector3f(fcp.getWidth(),fcp.getHeight(), 0);
                BoxCollisionShape fcheckBox = new BoxCollisionShape(fcheckhalfExtent);
                GhostControl fcheckGhost = new GhostControl(fcheckBox);
                fcheckGhost.setCollisionGroup(5);
                fcheckGhost.setCollideWithGroups(2);
                PhysicsWrapper.getInstance().add(fcheckGhost);
                userDataNode.addControl(fCheckMc);
                userDataNode.addControl(fcheckGhost);
                break;
            case SPAWNPOINT:
                if(!typeToCreate.getSpawnable()){
                }
                int amount = userDataNode.getUserData("AMOUNT");
                NodeType type = null;
                String nameOfSpawnable = userDataNode.getUserData("TYPE");
                switch(nameOfSpawnable) {
                    case "PLAYER":
                        type = NodeType.PLAYER;
                        break;
                    case "BOSS":
                        type = NodeType.BOSS;
                        break;
                    case "MINION":
                        type = NodeType.MINION;
                        break;
                }
                SpawnControl sc = new SpawnControl();
                SpawnPoint sp = new SpawnPoint(sc, amount, type, width);
                Vector3f spawnHalfExtent = new Vector3f(sp.getWidth(),sp.getHeight(), 0);
                BoxCollisionShape box = new BoxCollisionShape(spawnHalfExtent);
                GhostControl spawnGhost = new GhostControl(box);
                spawnGhost.setCollisionGroup(4);
                spawnGhost.setCollideWithGroups(2);
                PhysicsWrapper.getInstance().add(spawnGhost);
                ModelControl spawnMc = new ModelControl(sp);
                userDataNode.addControl(spawnMc);
                userDataNode.addControl(spawnGhost);
                userDataNode.addControl(sc);
                break;
            case GAMEOBJECT:
                //todo add stuffzz for gameobjects.
                break;
        }
        
    }
    
}
