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
 *
 * @author kakan
 */
class CollisionObjectFactory {
    
    static Node createCollisionObject(NodeType typeToCreate, Node userDataNode) {
        Node node = new Node();
        float width = userDataNode.getUserData("WIDTH");
        switch (typeToCreate) {
            case CHECKPOINT:
                int level = userDataNode.getUserData("LEVEL");
                int number = userDataNode.getUserData("NUMBER");
                Checkpoint cp = new Checkpoint(level, number, width);
                ModelControl CheckMc = new ModelControl(cp);
                CollisionObjectControl CheckCc = new CollisionObjectControl(cp);
                node.addControl(CheckMc);
                node.addControl(CheckCc);
                return node;
            case SPAWNPOINT:
                if(!typeToCreate.getSpawnable()){
                    return null;
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
                node.addControl(spawnMc);
                node.addControl(spawnCc);
                node.addControl(sc);
                return node;  
        }
        
        return null;
    }
    
}
