/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.LifeOfAGoblin.jME3.factory;

import com.jme3.scene.Node;
import edu.chl.LifeOfAGoblin.jME3.controller.CollisionObjectControl;
import edu.chl.LifeOfAGoblin.jME3.controller.ModelControl;
import edu.chl.LifeOfAGoblin.jME3.controller.SpawnControl;
import edu.chl.LifeOfAGoblin.model.Checkpoint;
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
                ModelControl CheckMc = new ModelControl(cp);
                CollisionObjectControl CheckCc = new CollisionObjectControl(cp);
                userDataNode.addControl(CheckMc);
                userDataNode.addControl(CheckCc);
                break;
            case SPAWNPOINT:
                if(!typeToCreate.getSpawnable()){
                }
                int amount = userDataNode.getUserData("AMOUNT");
                NodeType type = null;
                String nameOfSpawnable = typeToCreate.toString();
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
                CollisionObjectControl spawnCc = new CollisionObjectControl(sp);
                ModelControl spawnMc = new ModelControl(sp);
                userDataNode.addControl(spawnMc);
                userDataNode.addControl(spawnCc);
                userDataNode.addControl(sc);
                break;
            case GAMEOBJECT:
                //todo add stuffzz for gameobjects.
                break;
        }
        
    }
    
}
